package com.pugliatti.andrea.retrofocus.controller;

import com.pugliatti.andrea.retrofocus.dto.MountDTO;
import com.pugliatti.andrea.retrofocus.mapper.MountMapper;
import com.pugliatti.andrea.retrofocus.service.MountService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mounts")
public class MountRestController {

    private final MountService service;
    private final MountMapper mapper;

    MountRestController(MountService mountService, MountMapper mapper) {
        this.service = mountService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<MountDTO>> index(
        @RequestParam(value = "q", required = false) String name
    ) {
        List<MountDTO> mounts = service
            .findAllOrByNameContaining(name)
            .stream()
            .map(mapper::toDTO)
            .toList();
        return new ResponseEntity<>(mounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MountDTO> show(@PathVariable Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
            mapper.toDTO(service.getById(id)),
            HttpStatus.OK
        );
    }
}
