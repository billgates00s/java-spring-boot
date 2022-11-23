package com.tma.bookmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tma.bookmanagement.entities.Employee;
import com.tma.bookmanagement.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee_list")
    public String listEmployee(Model model) {
        model.addAttribute("listEmployee", employeeService.findAll());
        return "list_employee";
    }

    @RequestMapping("/employee_save")
    public String insertEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_save";
    }

    @RequestMapping("/saveEmployee")
    public String doSaveEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/employee_list";
    }

    @RequestMapping("/employee_view/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        }
        return "employee_view";
    }

    @RequestMapping("/employee_update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        }
        return "employee_update";
    }

    @RequestMapping("/updateEmployee")
    public String doUpdateEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/employee_list";
    }

    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/employee_list";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("name_employee") String name, Model model){
        List<Employee> list = employeeService.findByName(name);
        model.addAttribute("listEmployee", list);
        return "list_employee";
    }
}
