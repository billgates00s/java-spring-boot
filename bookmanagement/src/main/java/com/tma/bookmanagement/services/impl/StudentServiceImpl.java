package com.tma.bookmanagement.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.bookmanagement.entities.Student;
import com.tma.bookmanagement.repositories.StudentRepository;
import com.tma.bookmanagement.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.insertStudent(student.getName_student(), student.getIdentity_card(), student.getAddress(), student.getBirth_date());

    }
    @Override
    public void updateStudent(Long id, Student student) {

        studentRepository.updateStudent(id, student.getName_student(), student.getIdentity_card(), student.getAddress(), student.getBirth_date());
    }
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deletedStudent(id);

    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }
}
