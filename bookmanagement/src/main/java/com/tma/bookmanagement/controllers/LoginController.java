package com.tma.bookmanagement.controllers;

import com.tma.bookmanagement.utils.WebUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    //add request mapping for /access-denied
    @GetMapping("/access_denied")
    public String showAccessDenied(Model model, Principal principal){
        if(principal!=null){

            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtil.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }

        return "access_denied";
    }
}
