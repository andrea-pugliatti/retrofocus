package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pugliatti.andrea.retrofocus.model.Mount;
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

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable Integer id) {
        if (!service.existsById(id)) {
            return "redirect:/mounts";
        }
        Mount mount = service.getById(id);
        model.addAttribute("mount", mount);
        model.addAttribute("cameras", service.findAllCameras(mount));
        model.addAttribute("lenses", service.findAllLenses(mount));
        return "mounts/show";
    }

}
