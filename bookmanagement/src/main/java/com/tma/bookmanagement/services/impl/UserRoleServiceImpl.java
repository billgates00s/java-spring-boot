package com.tma.bookmanagement.services.impl;

import com.tma.bookmanagement.entities.UserRole;
import com.tma.bookmanagement.repositories.UserRoleRepository;
import com.tma.bookmanagement.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public Optional<UserRole> findById(Long id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}
