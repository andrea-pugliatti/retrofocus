package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pugliatti.andrea.retrofocus.service.BrandService;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private BrandService service;

    public BrandController(BrandService brandService) {
        this.service = brandService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("brands", service.findAll());
        return "brands/index";
    }
}
