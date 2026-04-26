package com.pugliatti.andrea.retrofocus.controller;

import com.pugliatti.andrea.retrofocus.dto.LensDTO;
import com.pugliatti.andrea.retrofocus.mapper.LensMapper;
import com.pugliatti.andrea.retrofocus.service.LensService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lenses")
public class LensRestController {

    private final LensService service;
    private final LensMapper mapper;

    public LensRestController(LensService lensService, LensMapper lensMapper) {
        this.service = lensService;
        this.mapper = lensMapper;
    }

    @GetMapping
    public ResponseEntity<List<LensDTO>> index(
        @RequestParam(value = "q", required = false) String name,
        @RequestParam(value = "m", required = false) Integer mountId
    ) {
        List<LensDTO> lenses = service
            .findAllOrWithFilters(name, mountId)
            .stream()
            .map(mapper::toDto)
            .toList();
        return new ResponseEntity<>(lenses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LensDTO> show(@PathVariable Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
            mapper.toDto(service.getById(id)),
            HttpStatus.OK
        );
    }
}
