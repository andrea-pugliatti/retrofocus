package com.pugliatti.andrea.retrofocus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Camera;
import com.pugliatti.andrea.retrofocus.model.Mount;
import com.pugliatti.andrea.retrofocus.repository.CameraRepository;
import com.pugliatti.andrea.retrofocus.repository.MountRepository;
import com.pugliatti.andrea.retrofocus.repository.specification.CameraSpecifications;

@Service
public class CameraService {
    private final CameraRepository cameraRepository;
    private final MountRepository mountRepository;

    public CameraService(CameraRepository cameraRepository, MountRepository mountRepository) {
        this.cameraRepository = cameraRepository;
        this.mountRepository = mountRepository;
    }

    public List<Camera> findAllOrWithFilters(String name, Integer mountId) {
        return cameraRepository.findAll(
                PredicateSpecification.where(CameraSpecifications.hasName(name))
                        .and(CameraSpecifications.hasMount(mountId)));
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
