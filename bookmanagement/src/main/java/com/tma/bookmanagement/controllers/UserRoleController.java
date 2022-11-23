package com.tma.bookmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tma.bookmanagement.entities.UserRole;
import com.tma.bookmanagement.services.UserRoleService;

@Controller
@RequestMapping("userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    @GetMapping("/list_user_role")
    public String list(Model model){
        model.addAttribute("listUserRole",userRoleService.findAll());
        return "list_user_role";
    }
    @GetMapping("user_role_view/{id}")
    public String viewRole(@PathVariable("id") Long id, Model model){
        Optional<UserRole> userRole = userRoleService.findById(id);
        if(userRole.isPresent()){
            model.addAttribute("userRole", userRole.get());
        }
        return "user_role_view";

    }
    @GetMapping("/user_role_save")
    public String insertUserRole(Model model){
        model.addAttribute("userRole", new UserRole());
        return "user_role_save";
    }
    @PostMapping("/saveUserRole")
    public String doSaveUserRole(@ModelAttribute UserRole userRole){
        userRoleService.save(userRole);
        return "redirect:/userRole/list_user_role";
    }
    @GetMapping("/user_role_update/{id}")
    public String updateUserRole(@PathVariable("id") Long id, Model model){
        Optional<UserRole> userRole = userRoleService.findById(id);
        if(userRole.isPresent()){
            model.addAttribute("userRole",userRole.get());
        }
        return "user_role_update";
    }
    @GetMapping("/updateUserRole")
    public String doUpdateUserRole(@ModelAttribute UserRole userRole){
        userRoleService.save(userRole);
        return "redirect:/userRole/list_user_role";
    }
    @GetMapping("/deleteUserRole/{id}")
    public String deleteUserRole(@PathVariable("id") Long id){
        userRoleService.deleteUserRole(id);
        return "redirect:/userRole/list_user_role";
    }
}
