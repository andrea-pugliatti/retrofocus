package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pugliatti.andrea.retrofocus.service.CameraService;

@Controller
@RequestMapping("/cameras")
public class CameraController {
    private CameraService service;

    public CameraController(CameraService cameraService) {
        this.service = cameraService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cameras", service.findAll());
        return "cameras/index";
    }

}
