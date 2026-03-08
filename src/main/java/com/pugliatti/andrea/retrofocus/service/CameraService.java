package com.pugliatti.andrea.retrofocus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Camera;
import com.pugliatti.andrea.retrofocus.model.Mount;
import com.pugliatti.andrea.retrofocus.repository.CameraRepository;

@Service
public class CameraService {
    private CameraRepository cameraRepository;
    private MountService mountRepository;

    public CameraService(CameraRepository cameraRepository, MountService mountRepository) {
        this.cameraRepository = cameraRepository;
        this.mountRepository = mountRepository;
    }

    public List<Camera> findAll() {
        return cameraRepository.findAll();
    }

    public List<Camera> findByNameContaining(String name) {
        return cameraRepository.findByNameContaining(name);
    }

    public List<Camera> findAllOrByNameContaining(String name) {
        if (name == null) {
            return findAll();
        }
        return findByNameContaining(name);
    }

    public Optional<Camera> findById(Integer id) {
        return cameraRepository.findById(id);
    }

    public Boolean existsById(Integer id) {
        return cameraRepository.existsById(id);
    }

    public Camera getById(Integer id) {
        return findById(id).get();
    }

    public List<Mount> findAllMounts() {
        return mountRepository.findAll();
    }

    public Camera save(Camera camera) {
        return cameraRepository.save(camera);
    }

    public Camera edit(Camera camera) {
        return cameraRepository.save(camera);
    }

    public void deleteById(Integer id) {
        cameraRepository.deleteById(id);
    }
}
