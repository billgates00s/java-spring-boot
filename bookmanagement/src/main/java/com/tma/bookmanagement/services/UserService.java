package com.tma.bookmanagement.services;

import java.util.List;
import java.util.Optional;

import com.tma.bookmanagement.entities.User;

public interface UserService {
    User findByUserName(String username);
    Optional<User> findById(Long id);

    boolean checkLogin(String username, String password);

    List<User> findAll();

    void save(User user);
    public void insertUser(User user);

    void deleteUser(Long id);

}
