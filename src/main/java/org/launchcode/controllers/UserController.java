package org.launchcode.controllers;

import org.launchcode.models.Client;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("")
    public String displayAddUserForm() {

        return "/user/add";
    }

    @PostMapping("")
    String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
    // add form submission handling code here
        if (!user.getPassword().equals(verify)) {
            model.addAttribute("username" , user.getUsername());
            model.addAttribute("email" , user.getEmail());
            model.addAttribute("error" , "Passwords mis-match!");
            return "/user/add";
        }
        model.addAttribute("user" , user);
        return "/user/index";
    }

}
