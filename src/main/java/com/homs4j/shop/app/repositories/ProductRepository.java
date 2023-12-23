package com.homs4j.shop.app.repositories;

import com.homs4j.shop.app.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    public Optional<Product> findProductById(String productId);

    public int addProduct(Product product);

    public int updateProduct(Product product);

    public int deleteProduct(String productId);

    public List<Product> findAll(int offset, int limit);

    public List<Product> findAllByCategory(int offset, int limit, String category);

    public int updateStock(String productId,Long numberOfUnits);

    //TODO: Filter by price
    //TODO: Filter by price and category
}
