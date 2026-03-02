package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pugliatti.andrea.retrofocus.service.MountService;

@Controller
@RequestMapping("/mounts")
public class MountController {
    private MountService service;

    public MountController(MountService mountService) {
        this.service = mountService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("mounts", service.findAll());
        return "mounts/index";
    }
}
