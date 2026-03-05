package com.pugliatti.andrea.retrofocus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Camera;
import com.pugliatti.andrea.retrofocus.repository.CameraRepository;

@Service
public class CameraService {
    private CameraRepository repo;

    public CameraService(CameraRepository cameraRepository) {
        this.repo = cameraRepository;
    }

    public List<Camera> findAll() {
        return repo.findAll();
    }

    public List<Camera> findByNameContaining(String name) {
        return repo.findByNameContaining(name);
    }

    public List<Camera> findAllOrByNameContaining(String name) {
        if (name == null) {
            return findAll();
        }
        return findByNameContaining(name);
    }

    public Optional<Camera> findById(Integer id) {
        return repo.findById(id);
    }

    public Boolean existsById(Integer id) {
        return repo.existsById(id);
    }

    public Camera getById(Integer id) {
        return findById(id).get();
    }
}
