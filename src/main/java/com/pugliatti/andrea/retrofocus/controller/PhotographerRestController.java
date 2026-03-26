package com.pugliatti.andrea.retrofocus.controller;

import java.util.List;

import com.pugliatti.andrea.retrofocus.model.Photographer;
import com.pugliatti.andrea.retrofocus.service.PhotographerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/photographers")
public class PhotographerRestController {
    private final PhotographerService service;

    public PhotographerRestController(PhotographerService photographerService) {
        this.service = photographerService;
    }

    @GetMapping
    public ResponseEntity<List<Photographer>> index(@RequestParam(value = "q", required = false) String name) {
        return new ResponseEntity<>(service.findAllOrByNameContaining(name), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photographer> show(@PathVariable Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
}
