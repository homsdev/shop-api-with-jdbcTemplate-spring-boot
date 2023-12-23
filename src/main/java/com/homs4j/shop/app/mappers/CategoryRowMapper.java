package com.homs4j.shop.app.mappers;

import com.homs4j.shop.app.models.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Category.builder()
                .categoryId(rs.getString("category_id"))
                .name(rs.getString("name"))
                .build();
    }
}
