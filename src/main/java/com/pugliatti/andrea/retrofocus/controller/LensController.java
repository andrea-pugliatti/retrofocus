package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pugliatti.andrea.retrofocus.service.LensService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/lenses")
public class LensController {
    private LensService service;

    public LensController(LensService lensService) {
        this.service = lensService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("lenses", service.findAll());
        return "lenses/index";
    }

}
