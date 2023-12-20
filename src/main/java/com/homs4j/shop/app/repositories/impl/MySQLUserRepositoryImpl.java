package com.homs4j.shop.app.repositories.impl;

import com.homs4j.shop.app.mappers.UserRowMapper;
import com.homs4j.shop.app.models.User;
import com.homs4j.shop.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class MySQLUserRepositoryImpl implements UserRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    private final String USER_ID = "user_id";
    private final String FIRST_NAME = "first_name";
    private final String LAST_NAME = "last_name";
    private final String USERNAME = "username";
    private final String EMAIL = "email";
    private final String USER_PWD = "user_pwd";
    private final String USER_ROLE = "user_role";
    private final String ADDRESS_ID = "address_id";
    private final String CREATED_AT = "created_at";
    private final String UPDATED_AT = "updated_at";
    private final String DATABASE = "app_user";

    @Autowired
    public MySQLUserRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createUser(User user) {
        String SQL = "INSERT INTO app_user(user_id,first_name,last_name,username,email,user_pwd,user_role,created_at)" +
                " VALUES(:user_id,:first_name,:last_name,:username,:email,:user_pwd,:user_role,:created_at)";
        Map<String,Object> params = new HashMap<>();
        params.put(USER_ID,user.getUserId());
        params.put(FIRST_NAME,user.getFirstName());
        params.put(LAST_NAME,user.getLastName());
        params.put(USERNAME,user.getUsername());
        params.put(EMAIL,user.getEmail());
        params.put(USER_PWD,user.getPassword());
        params.put(USER_ROLE,user.getRole());
        params.put(CREATED_AT,user.getCreatedAt());

        return jdbcTemplate.update(SQL, params);
    }

    @Override
    public Optional<User> findById(String userId) {
        String SQL = "SELECT * FROM app_user WHERE user_id = :user_id";
        Map<String,Object> params = new HashMap<>();
        params.put(USER_ID,userId);
        List<User> users = jdbcTemplate.query(SQL,params,new UserRowMapper());
        return users.stream().findFirst();
    }

    @Override
    public int updateUser(User user) {
        String SQL = "UPDATE app_user " +
                "SET first_name = :first_name, " +
                "last_name = :last_name, " +
                "username = :username, " +
                "email = :email, " +
                "updated_at = :updated_at " +
                "WHERE user_id = :user_id";
        Timestamp updated_at = Timestamp.valueOf(LocalDateTime.now());
        Map<String,Object> params =  new HashMap<>();
        params.put(USER_ID,user.getUserId());
        params.put(FIRST_NAME,user.getFirstName());
        params.put(LAST_NAME,user.getLastName());
        params.put(USERNAME,user.getUsername());
        params.put(EMAIL,user.getEmail());
        params.put(UPDATED_AT,updated_at);
        return jdbcTemplate.update(SQL,params);
    }

    @Override
    public int deleteUser(String userId) {
        String SQL = "DELETE FROM app_user WHERE user_id = :user_id";
        Map<String,Object> params = new HashMap<>();
        params.put(USER_ID,userId);
        return jdbcTemplate.update(SQL,params);
    }

    @Override
    public List<User> findAll() {
        String SQL = "SELECT * FROM app_user";
        return jdbcTemplate.query(SQL,new UserRowMapper());
    }
}
