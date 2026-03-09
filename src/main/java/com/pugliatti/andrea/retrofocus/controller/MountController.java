package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pugliatti.andrea.retrofocus.model.Mount;
import com.pugliatti.andrea.retrofocus.service.MountService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/mounts")
public class MountController {
    private final MountService service;

    public MountController(MountService mountService) {
        this.service = mountService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "q", required = false) String name) {
        model.addAttribute("mounts", service.findAllOrByNameContaining(name));
        model.addAttribute("query", name);
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

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("mount", new Mount());
        model.addAttribute("edit", false);
        return "mounts/edit";
    }

    @PostMapping("/create")
    public String store(
            @Valid @ModelAttribute(name = "mount") Mount formMount,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "mounts/edit";
        }

        Mount mount = service.save(formMount);
        return "redirect:/mounts/" + mount.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        if (!service.existsById(id)) {
            model.addAttribute("mount", new Mount());
            model.addAttribute("edit", false);
        } else {
            model.addAttribute("mount", service.getById(id));
            model.addAttribute("edit", true);
        }
        return "mounts/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(
            @Valid @ModelAttribute(name = "mount") Mount formMount,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "mounts/edit";
        }
        Mount mount = service.edit(formMount);
        return "redirect:/mounts/" + mount.getId();
    }

    @PostMapping("/delete/{id}")
    public String postMethodName(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/mounts";
    }

}
