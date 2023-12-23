package com.homs4j.shop.app.mappers;

import com.homs4j.shop.app.enums.Condition;
import com.homs4j.shop.app.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Product.builder()
                .productId(rs.getString("product_id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .unitPrice(rs.getBigDecimal("unit_price"))
                .unitsInStock(rs.getLong("units_in_stock"))
                .unitsInOrder(rs.getLong("units_in_order"))
                .condition(Condition.valueOf(rs.getString("product_condition")))
                .discontinued(rs.getBoolean("discontinued"))
                .createdAt(rs.getTimestamp("created_at"))
                .updatedAt(rs.getTimestamp("updated_at"))
                .build();
    }
}
