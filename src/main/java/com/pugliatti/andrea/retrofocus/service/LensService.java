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
    private final MountRepository mountRepository;
    private final LensRepository lensRepository;

    public LensService(LensRepository lensRepository, MountRepository mountRepository) {
        this.lensRepository = lensRepository;
        this.mountRepository = mountRepository;
    }

    public List<Lens> findAllOrWithFilters(String name, Integer mountId) {
        if (mountId != null
                && mountRepository.existsById(mountId)
                && name != null
                && !name.isBlank()) {
            return lensRepository.findByNameContainingAndMount(name, mountRepository.findById(mountId).get());
        } else if (mountId != null && mountRepository.existsById(mountId)) {
            return lensRepository.findByMount(mountRepository.findById(mountId).get());
        } else if (name != null && !name.isBlank()) {
            return lensRepository.findByNameContaining(name);
        } else {
            return lensRepository.findAll();
        }
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
