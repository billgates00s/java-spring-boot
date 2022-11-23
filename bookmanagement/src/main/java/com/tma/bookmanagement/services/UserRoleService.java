package com.tma.bookmanagement.services;

import java.util.List;
import java.util.Optional;

import com.tma.bookmanagement.entities.UserRole;

public interface UserRoleService {
    public void save(UserRole userRole);
    Optional<UserRole> findById(Long id);
    public List<UserRole> findAll();
    public void deleteUserRole(Long id);

}
