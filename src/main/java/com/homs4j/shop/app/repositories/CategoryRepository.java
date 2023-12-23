package com.homs4j.shop.app.repositories;

import com.homs4j.shop.app.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    public List<Category> findAll();
    public Optional<Category> findById(String categoryId);
}
