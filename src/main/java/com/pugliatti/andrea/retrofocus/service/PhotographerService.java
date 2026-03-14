package com.pugliatti.andrea.retrofocus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Camera;
import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.model.Photographer;
import com.pugliatti.andrea.retrofocus.repository.CameraRepository;
import com.pugliatti.andrea.retrofocus.repository.LensRepository;
import com.pugliatti.andrea.retrofocus.repository.PhotographerRepository;

@Service
public class PhotographerService {
    private final PhotographerRepository photographerRepository;
    private final CameraRepository cameraRepository;
    private final LensRepository lensRepository;

    public PhotographerService(
            PhotographerRepository photographerRepository,
            CameraRepository cameraRepository,
            LensRepository lensRepository) {
        this.photographerRepository = photographerRepository;
        this.cameraRepository = cameraRepository;
        this.lensRepository = lensRepository;
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

    public List<Camera> findAllCameras() {
        return cameraRepository.findAll();
    }

    public List<Lens> findAllLenses() {
        return lensRepository.findAll();
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
