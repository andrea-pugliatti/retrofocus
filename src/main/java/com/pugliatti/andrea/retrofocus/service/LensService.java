package com.pugliatti.andrea.retrofocus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.repository.LensRepository;

@Service
public class LensService {
    private LensRepository repo;

    public LensService(LensRepository lensRepository) {
        this.repo = lensRepository;
    }

    public List<Lens> findAll() {
        return repo.findAll();
    }

}
