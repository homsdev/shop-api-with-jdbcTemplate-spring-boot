package com.homs4j.shop.app.repositories.impl;

import com.homs4j.shop.app.mappers.CategoryRowMapper;
import com.homs4j.shop.app.models.Category;
import com.homs4j.shop.app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MySQLCategoryRepositoryImpl implements CategoryRepository {

    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySQLCategoryRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> findAll() {
        String SQL = "SELECT * FROM category";
        return jdbcTemplate.query(SQL,new CategoryRowMapper());
    }

    @Override
    public Optional<Category> findById(String categoryId) {
        String SQL = "SELECT * FROM category WHERE category_id = :category_id";
        Map<String, Object> params = new HashMap<>();
        params.put("category_id",categoryId);
        return jdbcTemplate.query(SQL,params,new CategoryRowMapper()).stream().findFirst();
    }
}
