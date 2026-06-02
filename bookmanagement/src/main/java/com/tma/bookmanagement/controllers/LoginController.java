package com.tma.bookmanagement.controllers;

import com.tma.bookmanagement.entities.User;
import com.tma.bookmanagement.services.UserService;
import com.tma.bookmanagement.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register_user")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register_user";
    }

    @PostMapping("/register_user")
    public String doSaveUser(@ModelAttribute User user) {
        user.setPass_word(passwordEncoder.encode(user.getPass_word()));
        userService.save(user);
        return "redirect:/login";
    }

    //add request mapping for /access-denied
    @GetMapping("/access_denied")
    public String showAccessDenied(Model model, Principal principal){
        if(principal!=null){

            org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtil.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }

        return "access_denied";
    }
}
