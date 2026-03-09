package com.pugliatti.andrea.retrofocus.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Lens> findById(Integer id) {
        return repo.findById(id);
    }

    public Lens getById(Integer id) {
        return findById(id).get();
    }

    public Boolean existsById(Integer id) {
        return repo.existsById(id);
    }

}
