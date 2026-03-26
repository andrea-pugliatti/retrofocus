package com.pugliatti.andrea.retrofocus.controller;

import com.pugliatti.andrea.retrofocus.model.Photographer;
import com.pugliatti.andrea.retrofocus.service.PhotographerService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/photographers")
public class PhotographerController {

    private final PhotographerService service;

    PhotographerController(PhotographerService photographerService) {
        this.service = photographerService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "q", required = false) String name) {
        model.addAttribute("photographers", service.findAllOrByNameContaining(name));
        model.addAttribute("query", name);
        return "photographers/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable Integer id) {
        if (!service.existsById(id)) {
            return "redirect:/photographers";
        }
        model.addAttribute("photographer", service.getById(id));

        return "photographers/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("photographer", new Photographer());
        model.addAttribute("edit", false);
        model.addAttribute("cameras", service.findAllCameras());
        model.addAttribute("lenses", service.findAllLenses());
        return "photographers/edit";
    }

    @PostMapping("/create")
    public String store(
            @Valid @ModelAttribute Photographer formPhotographer,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            model.addAttribute("cameras", service.findAllCameras());
            model.addAttribute("lenses", service.findAllLenses());
            return "photographers/edit";
        }

        Photographer newPhotographer = service.save(formPhotographer);
        return "redirect:/photographers/" + newPhotographer.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        if (!service.existsById(id)) {
            model.addAttribute("edit", false);
            model.addAttribute("photographer", new Photographer());
        } else {
            model.addAttribute("edit", true);
            model.addAttribute("photographer", service.getById(id));
        }
        model.addAttribute("cameras", service.findAllCameras());
        model.addAttribute("lenses", service.findAllLenses());
        return "photographers/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(
            @Valid @ModelAttribute Photographer formPhotographer,
            BindingResult bindingResult,
            @PathVariable Integer id,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            model.addAttribute("cameras", service.findAllCameras());
            model.addAttribute("lenses", service.findAllLenses());
            return "photographers/edit";
        }
        formPhotographer.setId(id);
        Photographer editedPhotographer = service.edit(formPhotographer);
        return "redirect:/photographers/" + editedPhotographer.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/photographers";
    }
}
