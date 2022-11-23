package com.tma.bookmanagement.controllers;

import com.tma.bookmanagement.utils.WebUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {
    @RequestMapping (value = {"/","/home"}, method = RequestMethod.GET)
    public String homePage(){
        return "index";
    }
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtil.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }
    @RequestMapping(value = "/adminInfo", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtil.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }



}
