package com.tma.bookmanagement.services;

import java.util.List;
import java.util.Optional;

import com.tma.bookmanagement.entities.Student;

public interface StudentService {
    List<Student> findAll();

    void insertStudent(Student student);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    void save(Student student);

    Optional<Student> findById(Long id);
}
