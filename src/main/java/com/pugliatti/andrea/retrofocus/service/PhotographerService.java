package com.pugliatti.andrea.retrofocus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Photographer;
import com.pugliatti.andrea.retrofocus.repository.PhotographerRepository;

@Service
public class PhotographerService {
    private final PhotographerRepository photographerRepository;

    public PhotographerService(PhotographerRepository photographerRepository) {
        this.photographerRepository = photographerRepository;
    }

    public List<Photographer> findAll() {
        return photographerRepository.findAll();
    }

    public List<Photographer> findByNameContaining(String name) {
        return photographerRepository.findByNameContaining(name);
    }

    public List<Photographer> findAllOrByNameContaining(String name) {
        if (name == null) {
            return findAll();
        }
        return findByNameContaining(name);
    }

    public Optional<Photographer> findById(Integer id) {
        return photographerRepository.findById(id);
    }

    public Boolean existsById(Integer id) {
        return photographerRepository.existsById(id);
    }

    public Photographer getById(Integer id) {
        return findById(id).get();
    }

    public Photographer save(Photographer photographer) {
        return photographerRepository.save(photographer);
    }

    public Photographer edit(Photographer photographer) {
        return photographerRepository.save(photographer);
    }

    public void deleteById(Integer id) {
        photographerRepository.deleteById(id);
    }
}
