package com.pugliatti.andrea.retrofocus.controller;

import com.pugliatti.andrea.retrofocus.dto.PhotographerDTO;
import com.pugliatti.andrea.retrofocus.mapper.PhotographerMapper;
import com.pugliatti.andrea.retrofocus.service.PhotographerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/photographers")
public class PhotographerRestController {

    private final PhotographerService service;
    private final PhotographerMapper mapper;

    public PhotographerRestController(
        PhotographerService photographerService,
        PhotographerMapper mapper
    ) {
        this.service = photographerService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<PhotographerDTO>> index(
        @RequestParam(value = "q", required = false) String name
    ) {
        List<PhotographerDTO> photographers = service
            .findAllOrByNameContaining(name)
            .stream()
            .map(mapper::toDto)
            .toList();
        return new ResponseEntity<>(photographers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotographerDTO> show(@PathVariable Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
            mapper.toDto(service.getById(id)),
            HttpStatus.OK
        );
    }
}
