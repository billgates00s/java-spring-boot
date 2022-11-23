package com.tma.bookmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tma.bookmanagement.entities.Student;
import com.tma.bookmanagement.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("student_list")
    public String listStudent(Model model) {
        model.addAttribute("listStudent", studentService.findAll());
        return "list_student";
    }

    @RequestMapping("/student_save")
    public String insertStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student_save";
    }

    @RequestMapping("/saveStudent")
    public String doSaveStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/student/student_list";
    }

    @RequestMapping("student_view/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
        }
        return "student_view";
    }

    @RequestMapping("/student_update/{id}")
    public String updateStudent(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
        }
        return "student_update";
    }

    @RequestMapping("/updateStudent")
    public String doUpdateStudent(@ModelAttribute Student student) {
        studentService.save(student);

        return "redirect:/student/student_list";
    }

    @RequestMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/student/student_list";
    }
}
