package com.pugliatti.andrea.retrofocus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.service.LensService;

@RestController
@CrossOrigin
@RequestMapping("/api/lenses")
public class LensRestController {
    private final LensService service;

    public LensRestController(LensService lensService) {
        this.service = lensService;
    }

    @GetMapping
    public ResponseEntity<List<Lens>> index(
            @RequestParam(value = "q", required = false) String name,
            @RequestParam(value = "m", required = false) Integer mountId) {
        return new ResponseEntity<>(service.findAllOrWithFilters(name, mountId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lens> show(@PathVariable Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

}
