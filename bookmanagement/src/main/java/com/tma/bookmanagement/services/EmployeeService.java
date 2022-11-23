package com.tma.bookmanagement.services;

import java.util.List;
import java.util.Optional;

import com.tma.bookmanagement.entities.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    void insertEmployee(Employee employee);

    void updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    void save(Employee employee);

    Optional<Employee> findById(Long id);
    List<Employee> findByName(String name_employees);
}
