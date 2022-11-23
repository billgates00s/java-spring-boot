package com.tma.bookmanagement.services;

import com.tma.bookmanagement.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<String> getRoleNames(Long id);
    List<Role> getAllRoles();
    void save(Role role);
    void deleteRole(Long id);
    Optional<Role> findById(Long id);
}
