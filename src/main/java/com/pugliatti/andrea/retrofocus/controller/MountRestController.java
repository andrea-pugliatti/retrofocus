package com.pugliatti.andrea.retrofocus.controller;

import java.util.List;
import com.pugliatti.andrea.retrofocus.service.MountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pugliatti.andrea.retrofocus.model.Mount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/api/mounts")
public class MountRestController {
    private final MountService service;

    MountRestController(MountService mountService) {
        this.service = mountService;
    }

    @GetMapping
    public ResponseEntity<List<Mount>> index(@RequestParam(value = "q", required = false) String name) {
        return new ResponseEntity<>(service.findAllOrByNameContaining(name), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mount> show(@PathVariable Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

}
