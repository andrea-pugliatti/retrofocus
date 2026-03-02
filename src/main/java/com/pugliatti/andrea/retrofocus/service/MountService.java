package com.pugliatti.andrea.retrofocus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Mount;
import com.pugliatti.andrea.retrofocus.repository.MountRepository;

@Service
public class MountService {
    private MountRepository repo;

    public MountService(MountRepository mountRepository) {
        this.repo = mountRepository;
    }

    public List<Mount> findAll() {
        return repo.findAll();
    }

}
