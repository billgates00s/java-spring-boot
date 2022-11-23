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

import com.tma.bookmanagement.entities.Role;
import com.tma.bookmanagement.services.RoleService;

@Controller
@RequestMapping("/role")
public class RoleControler {
    @Autowired
    private RoleService roleService;
    @GetMapping("/list_role")
    public String list(Model model){
        model.addAttribute("listRole",roleService.getAllRoles());
        return "list_role";
    }
    @GetMapping("role_view/{id}")
    public String viewRole(@PathVariable("id") Long id, Model model){
        Optional<Role> role = roleService.findById(id);
        if(role.isPresent()){
            model.addAttribute("role", role.get());
        }
        return "role_view";

    }
    @GetMapping("/role_save")
    public String insertRole(Model model){
        model.addAttribute("role", new Role());
        return "role_save";
    }
    @PostMapping("saveRole")
    public String doSaveRole(@ModelAttribute Role role){
        roleService.save(role);
        return "redirect:/role/list_role";
    }
    @GetMapping("/role_update/{id}")
    public String updateRole(@PathVariable("id") Long id, Model model){
        Optional<Role> role = roleService.findById(id);
        if(role.isPresent()){
            model.addAttribute("role",role.get());
        }
        return "role_update";
    }
    @GetMapping("/updateRole")
    public String doUpdateRole(@ModelAttribute Role role){
        roleService.save(role);
        return "redirect:/role/list_role";
    }
    @GetMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") Long id){
        roleService.deleteRole(id);
        return "redirect:/role/list_role";
    }

}
