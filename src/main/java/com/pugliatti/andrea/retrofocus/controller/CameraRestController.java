package com.pugliatti.andrea.retrofocus.controller;

import com.pugliatti.andrea.retrofocus.dto.CameraDTO;
import com.pugliatti.andrea.retrofocus.mapper.CameraMapper;
import com.pugliatti.andrea.retrofocus.service.CameraService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cameras")
public class CameraRestController {

    private final CameraService service;
    private final CameraMapper mapper;

    CameraRestController(
        CameraService cameraService,
        CameraMapper cameraMapper
    ) {
        this.service = cameraService;
        this.mapper = cameraMapper;
    }

    @GetMapping
    public ResponseEntity<List<CameraDTO>> index(
        @RequestParam(value = "q", required = false) String name,
        @RequestParam(value = "m", required = false) Integer mountId
    ) {
        List<CameraDTO> cameras = service
            .findAllOrWithFilters(name, mountId)
            .stream()
            .map(mapper::toDto)
            .toList();
        return new ResponseEntity<>(cameras, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CameraDTO> show(@PathVariable Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
            mapper.toDto(service.getById(id)),
            HttpStatus.OK
        );
    }
}
