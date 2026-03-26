package com.pugliatti.andrea.retrofocus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Camera;
import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.model.Mount;
import com.pugliatti.andrea.retrofocus.repository.CameraRepository;
import com.pugliatti.andrea.retrofocus.repository.LensRepository;
import com.pugliatti.andrea.retrofocus.repository.MountRepository;

@Service
public class MountService {
    private final LensRepository lensRepository;
    private final CameraRepository cameraRepository;
    private final MountRepository mountRepository;

    public MountService(MountRepository mountRepository, CameraRepository cameraRepository,
            LensRepository lensRepository) {
        this.mountRepository = mountRepository;
        this.cameraRepository = cameraRepository;
        this.lensRepository = lensRepository;
    }

    public List<Mount> findAll() {
        return mountRepository.findAll();
    }

    public List<Mount> findByNameContaining(String name) {
        return mountRepository.findByNameContaining(name);
    }

    public List<Mount> findAllOrByNameContaining(String name) {
        if (name == null) {
            return findAll();
        }
        return findByNameContaining(name);
    }

    public Optional<Mount> findById(Integer id) {
        return mountRepository.findById(id);
    }

    public Boolean existsById(Integer id) {
        return mountRepository.existsById(id);
    }

    public Mount getById(Integer id) {
        return findById(id).get();
    }

    public List<Camera> findAllCameras(Mount mount) {
        return cameraRepository.findByMount(mount);
    }

    public List<Lens> findAllLenses(Mount mount) {
        return lensRepository.findByMount(mount);
    }

    public Mount save(Mount mount) {
        return mountRepository.save(mount);
    }

    public Mount edit(Mount mount) {
        return mountRepository.save(mount);
    }

    public void deleteById(Integer id) {
        if (mountRepository.existsById(id)) {
            mountRepository.deleteById(id);
        }
    }
}
