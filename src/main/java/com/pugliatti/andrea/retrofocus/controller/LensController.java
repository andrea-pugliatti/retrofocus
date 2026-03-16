package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.service.LensService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/lenses")
public class LensController {
    private final LensService service;

    public LensController(LensService lensService) {
        this.service = lensService;
    }

    @GetMapping
    public String index(
            Model model,
            @RequestParam(value = "q", required = false) String name,
            @RequestParam(value = "m", required = false) Integer mountId) {
        model.addAttribute("lenses", service.findAllOrWithFilters(name, mountId));
        model.addAttribute("mounts", service.findAllMounts());
        model.addAttribute("query", name);
        model.addAttribute("mountId", mountId);
        return "lenses/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        if (!service.existsById(id)) {
            return "redirect:/lenses/index";
        }
        model.addAttribute("lens", service.getById(id));
        return "lenses/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("lens", new Lens());
        model.addAttribute("mounts", service.findAllMounts());
        model.addAttribute("edit", false);
        return "lenses/edit";
    }

    @PostMapping("/create")
    public String store(
            @Valid @ModelAttribute(name = "lens") Lens formLens,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mounts", service.findAllMounts());
            model.addAttribute("edit", false);
            return "lenses/edit";
        }
        Lens lens = service.save(formLens);
        return "redirect:/lenses/" + lens.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        if (!service.existsById(id)) {
            model.addAttribute("lens", new Lens());
            model.addAttribute("edit", false);
        } else {
            model.addAttribute("lens", service.getById(id));
            model.addAttribute("edit", true);
        }
        model.addAttribute("mounts", service.findAllMounts());
        return "/lenses/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(
            @Valid @ModelAttribute(name = "lens") Lens formLens,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mounts", service.findAllMounts());
            model.addAttribute("edit", true);
            return "lenses/edit";
        }
        Lens lens = service.edit(formLens);
        return "redirect:/lenses/" + lens.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/lenses";
    }
}
