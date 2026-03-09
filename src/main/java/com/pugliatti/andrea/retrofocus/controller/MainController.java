package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        return "index";
    }

}
