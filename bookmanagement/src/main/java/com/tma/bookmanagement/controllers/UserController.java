package com.tma.bookmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tma.bookmanagement.entities.User;
import com.tma.bookmanagement.services.UserService;


@Controller
@RequestMapping("admin")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping("/about")
//    public String about(Model model) {

//        Map<String, String> info = new HashMap<String, String>();
//        info.put("fullname","Nguyen Hong Nhan");
//        info.put("nickname", "linel");
//        info.put("gmail","nguyenhongnhana2@gmail.com");
//        info.put("facebook","https://www.facebook.com/hongnhan.nguyen.750");
//        info.put("website","null");
//        info.put("Phone number", "0389614228");
    // Tạo ra thông tin
//        List<Info> profile = new ArrayList<>();
//        profile.add(new Info("fullname", "Nguyễn Hồng Nhân"));
//        profile.add(new Info("nickname", "zero"));
//        profile.add(new Info("gmail", "nguyenhongnhana2@gmail.com"));
//        profile.add(new Info("facebook", "https://www.facebook.com/hongnhan.nguyen.750"));
//        profile.add(new Info("website", "null"));
//        profile.add(new Info("Phone number", "0389614228"));
//
//        // Đưa thông tin vào Model
//        model.addAttribute("nhanProfile", profile);
//
//        return "about";
//    }

//    @GetMapping("/hello")
//    public String hello(Model model){
//        model.addAttribute("theDate", new Date());
//        return "hello";
//    }
//
//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("user", new User());
//        return "login";
//    }
//    @RequestMapping(value = { "/admin/accountInfo" }, method = RequestMethod.GET)
//    public String accountInfo(Model model) {
//
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails.getPassword());
//        System.out.println(userDetails.getUsername());
//        System.out.println(userDetails.isEnabled());
//
//        model.addAttribute("userDetails", userDetails);
//        return "accountInfo";
//    }
//
//    @RequestMapping(value = "/checkLogin", method = {RequestMethod.POST, RequestMethod.GET})
//    public String checkLogin(@ModelAttribute User user, Model model, HttpSession session) {
//        if(userService.checkLogin(user.getUser_name(), user.getPass_word())){
//            System.out.println("Login is successfully");
//            session.setAttribute("username", user.getUser_name());
//            model.addAttribute("listUser", userService.findAll());
//            return "index";
//        }else {
//            System.out.println("Login fail");
//            model.addAttribute("error", "User not exit or user not yet active");
//            return "login";
//        }
//    }

//    @GetMapping("/home")
//    public String homePage(Model model) {
//        model.addAttribute("home","This is book management page");
//        return "home";
//    }

    @GetMapping("/register_user")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register_user";
    }

    @RequestMapping(value = "/saveUser", method = {RequestMethod.POST})
    public String doSaveUser(@ModelAttribute User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPass_word(encoder.encode(user.getPass_word()));
        userService.save(user);
        return "redirect:/admin/user_list";

    }

    @GetMapping("user_list")
    public String listUser(Model model) {
        model.addAttribute("listUser", userService.findAll());
        return "list_user";
    }

    @GetMapping("/user_view/{id}")
    public String viewUser(@PathVariable Long id, Model model) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
        return "user_view";
    }

    @GetMapping("/user_update/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
        return "user_update";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String doUpdateUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin/user_list";
    }

//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.removeAttribute("username");
//        return "redirect:/admin/login";
//    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String doDeleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user_list";
    }


}
