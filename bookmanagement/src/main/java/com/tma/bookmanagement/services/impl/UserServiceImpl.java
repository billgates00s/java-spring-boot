package com.tma.bookmanagement.services.impl;

import com.tma.bookmanagement.entities.User;
import com.tma.bookmanagement.repositories.UserRepository;
import com.tma.bookmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean checkLogin(String username, String password) {

        User user = findByUserName(username);
        if (user.isActive() && user.getUser_name().equals(username) && user.getPass_word().equals(password)) {
            return true;
        }
        return false;

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void insertUser(User user) {
        userRepository.insertUser(user.getUser_name(),user.getPass_word(),user.isActive());
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
