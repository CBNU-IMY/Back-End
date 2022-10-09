package com.example.g_server.Repository;

import com.example.g_server.Domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User sign_up(User user);
    Optional<User> findById(int id);

    List<User> findAll();
}
