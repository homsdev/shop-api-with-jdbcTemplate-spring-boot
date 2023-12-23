package com.homs4j.shop.app.repositories.impl;

import com.homs4j.shop.app.mappers.CategoryRowMapper;
import com.homs4j.shop.app.mappers.ProductRowMapper;
import com.homs4j.shop.app.models.Category;
import com.homs4j.shop.app.models.Product;
import com.homs4j.shop.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;

@Repository
public class MySQLProductRepositoryImpl implements ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySQLProductRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Product> findProductById(String productId) {
        String SQL = "SELECT * FROM product WHERE product_id = :product_id";
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", productId);
        List<Product> products = jdbcTemplate.query(SQL, params, new ProductRowMapper());
        return products.stream().findFirst();
    }

    @Override
    public int addProduct(Product product) {
        String SQL = "INSERT INTO product(product_id,name,description,unit_price,units_in_stock,product_condition,category_id,created_at)" +
                " values(:product_id,:name,:description,:unit_price,:units_in_stock,:product_condition,:category_id,:created_at)";
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", product.getProductId());
        params.put("name", product.getName());
        params.put("description", product.getDescription());
        params.put("unit_price", product.getUnitPrice());
        params.put("units_in_stock", product.getUnitsInStock());
        params.put("product_condition", product.getCondition());
        params.put("category_id", product.getCategory().getCategoryId());
        params.put("created_at", product.getCreatedAt());

        return jdbcTemplate.update(SQL, params);
    }

    @Override
    public int updateProduct(Product product) {
        String SQL = "UPDATE product SET name=:name, description=:description, unit_price=:unit_price, updated_at=:updated_at" +
                " WHERE product_id = :product_id";
        Map<String, Object> params = new HashMap<>();
        params.put("name", product.getName());
        params.put("description", product.getDescription());
        params.put("unit_price", product.getUnitPrice());
        params.put("updated_at", product.getUpdatedAt());
        params.put("product_id", product.getProductId());

        return jdbcTemplate.update(SQL, params);
    }

    @Override
    public int deleteProduct(String productId) {
        String SQL = "DELETE FROM product WHERE product_id=:product_id";
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", productId);
        return jdbcTemplate.update(SQL, params);
    }

    @Override
    public List<Product> findAll(int offset, int limit) {
        String SQL = "SELECT * FROM product p LIMIT :limit OFFSET :offset";
        Map<String, Object> params = new HashMap<>();
        params.put("limit", limit);
        params.put("offset", offset);
        return jdbcTemplate.query(SQL, params, new ProductRowMapper());
    }

    @Override
    public List<Product> findAllByCategory(int offset, int limit, String category) {
        String SQL = "SELECT * FROM product p INNER JOIN category c " +
                "ON p.category_id = c.category_id " +
                "WHERE c.name = :category " +
                "LIMIT :limit OFFSET :offset";
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("limit", limit);
        params.put("offset", offset);

        return jdbcTemplate.query(SQL, params, (ResultSet rs) -> {
            List<Product> productList = new ArrayList<>();
            while (rs.next()) {
                Product product = new ProductRowMapper().mapRow(rs, 1);
                Category productCategory = new CategoryRowMapper().mapRow(rs, 1);
                if (product != null && productCategory != null) {
                    product.setCategory(productCategory);
                    productList.add(product);
                }
            }
            return productList;
        });
    }

    @Override
    public int updateStock(String productId, Long numberOfUnits) {
        String SQL = "UPDATE product SET units_in_stock = :units_in_stock WHERE product_id = :product_id";
        Map<String, Object> params = new HashMap<>();
        params.put("units_in_stock", numberOfUnits);
        params.put("product_id", productId);
        return jdbcTemplate.update(SQL, params);
    }
}
