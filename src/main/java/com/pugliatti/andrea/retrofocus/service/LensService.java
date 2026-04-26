package com.pugliatti.andrea.retrofocus.service;

import com.pugliatti.andrea.retrofocus.exception.ResourceNotFoundException;
import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.model.Mount;
import com.pugliatti.andrea.retrofocus.repository.LensRepository;
import com.pugliatti.andrea.retrofocus.repository.MountRepository;
import com.pugliatti.andrea.retrofocus.repository.specification.LensSpecifications;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

@Service
public class LensService {

    private final MountRepository mountRepository;
    private final LensRepository lensRepository;

    public LensService(
        LensRepository lensRepository,
        MountRepository mountRepository
    ) {
        this.lensRepository = lensRepository;
        this.mountRepository = mountRepository;
    }

    public List<Lens> findAllOrWithFilters(String name, Integer mountId) {
        return lensRepository.findAll(
            PredicateSpecification.where(LensSpecifications.hasName(name)).and(
                LensSpecifications.hasMount(mountId)
            )
        );
    }

    public Optional<Lens> findById(Integer id) {
        return lensRepository.findById(id);
    }

    public Lens getById(Integer id) {
        return findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Lens not found with id: " + id)
        );
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
        if (lensRepository.existsById(id)) {
            lensRepository.deleteById(id);
        }
    }
}
