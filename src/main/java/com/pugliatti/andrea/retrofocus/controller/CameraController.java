package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pugliatti.andrea.retrofocus.model.Camera;
import com.pugliatti.andrea.retrofocus.service.CameraService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/cameras")
public class CameraController {
    private final CameraService service;

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

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("camera", new Camera());
        model.addAttribute("edit", false);
        model.addAttribute("mounts", service.findAllMounts());
        return "cameras/edit";
    }

    @PostMapping("/create")
    public String store(
            @Valid @ModelAttribute("camera") Camera formCamera,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            model.addAttribute("mounts", service.findAllMounts());
            return "/cameras/edit";
        }
        Camera camera = service.save(formCamera);
        return "redirect:/cameras/" + camera.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Integer cameraId) {
        if (!service.existsById(cameraId)) {
            model.addAttribute("camera", new Camera());
            model.addAttribute("edit", false);
        } else {
            model.addAttribute("camera", service.getById(cameraId));
            model.addAttribute("edit", true);
        }

        model.addAttribute("mounts", service.findAllMounts());
        return "cameras/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(
            Model model,
            @Valid @ModelAttribute(name = "camera") Camera formCamera,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            model.addAttribute("mounts", service.findAllMounts());
            return "cameras/edit";
        }
        Camera camera = service.edit(formCamera);
        return "redirect:/cameras/" + camera.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer cameraId) {
        service.deleteById(cameraId);
        return "redirect:/cameras";
    }

}
