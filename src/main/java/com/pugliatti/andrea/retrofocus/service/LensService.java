package com.pugliatti.andrea.retrofocus.service;

import java.util.List;
import java.util.Optional;
import com.pugliatti.andrea.retrofocus.repository.MountRepository;
import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.model.Mount;
import com.pugliatti.andrea.retrofocus.repository.LensRepository;

@Service
public class LensService {

    private MountRepository mountRepository;
    private LensRepository lensRepository;

    public LensService(LensRepository lensRepository, MountRepository mountRepository) {
        this.lensRepository = lensRepository;
        this.mountRepository = mountRepository;
    }

    public List<Lens> findAll() {
        return lensRepository.findAll();
    }

    public List<Lens> findByNameContaining(String name) {
        return lensRepository.findByNameContaining(name);
    }

    public List<Lens> findAllOrByNameContaining(String name) {
        if (name == null) {
            return findAll();
        }
        return findByNameContaining(name);
    }

    public Optional<Lens> findById(Integer id) {
        return lensRepository.findById(id);
    }

    public Lens getById(Integer id) {
        return findById(id).get();
    }

    public Boolean existsById(Integer id) {
        return lensRepository.existsById(id);
    }

    public List<Mount> findAllMounts() {
        return mountRepository.findAll();
    }

    public Lens save(Lens lens) {
        return lensRepository.save(lens);
    }

    public Lens edit(Lens lens) {
        return lensRepository.save(lens);
    }

    public void deleteById(Integer id) {
        lensRepository.deleteById(id);
    }
}
