package com.homs4j.shop.app.mappers;

import com.homs4j.shop.app.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User.Builder()
                .userId(rs.getString("user_id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .username(rs.getString("username"))
                .email(rs.getString("email"))
                .password(rs.getString("user_pwd"))
                .role(rs.getString("user_role"))
                .createdAt(rs.getTimestamp("created_at"))
                .updatedAt(rs.getTimestamp("updated_at"))
                .build();
        return user;
    }
}
