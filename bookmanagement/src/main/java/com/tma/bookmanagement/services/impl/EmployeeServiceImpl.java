package com.tma.bookmanagement.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.bookmanagement.entities.Employee;
import com.tma.bookmanagement.repositories.EmployeeRepository;
import com.tma.bookmanagement.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee.getName_employee(), employee.getIdentity_card(), employee.getAddress());

    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        employeeRepository.updateEmployee(id, employee.getName_employee(), employee.getIdentity_card(), employee.getAddress());
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deletedEmployee(id);

    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name_employee) {
        return employeeRepository.findByName(name_employee);
    }
}
