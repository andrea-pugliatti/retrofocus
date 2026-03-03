package com.pugliatti.andrea.retrofocus.service;

import java.util.List;

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

}
