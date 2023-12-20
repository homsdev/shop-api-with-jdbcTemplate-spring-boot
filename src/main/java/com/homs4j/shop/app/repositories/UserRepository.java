package com.homs4j.shop.app.repositories;

import com.homs4j.shop.app.dto.requests.PostUserDTO;
import com.homs4j.shop.app.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public int createUser(User user);
    public Optional<User> findById(String userId);
    public int updateUser(User user);
    public int deleteUser(String userId);

    public List<User> findAll();
}
