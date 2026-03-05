package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pugliatti.andrea.retrofocus.service.CameraService;

@Controller
@RequestMapping("/cameras")
public class CameraController {
    private CameraService service;

    public CameraController(CameraService cameraService) {
        this.service = cameraService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "q", required = false) String name) {
        model.addAttribute("cameras", service.findAllOrByNameContaining(name));
        model.addAttribute("query", name);
        return "cameras/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable(name = "id") Integer cameraId) {
        if (!service.existsById(cameraId)) {
            return "redirect:/cameras";
        }

        model.addAttribute("camera", service.getById(cameraId));
        return "cameras/show";
    }

}
