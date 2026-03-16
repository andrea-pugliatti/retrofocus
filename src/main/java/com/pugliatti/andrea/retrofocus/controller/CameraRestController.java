package com.pugliatti.andrea.retrofocus.controller;

import java.util.List;
import com.pugliatti.andrea.retrofocus.service.CameraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pugliatti.andrea.retrofocus.model.Camera;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
@RequestMapping("/api/cameras")
public class CameraRestController {
    private final CameraService service;

    CameraRestController(CameraService cameraService) {
        this.service = cameraService;
    }

    @GetMapping
    public ResponseEntity<List<Camera>> index(
            @RequestParam(value = "q", required = false) String name,
            @RequestParam(value = "m", required = false) Integer mountId) {
        return new ResponseEntity<>(service.findAllOrWithFilters(name, mountId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camera> show(@PathVariable Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
}
