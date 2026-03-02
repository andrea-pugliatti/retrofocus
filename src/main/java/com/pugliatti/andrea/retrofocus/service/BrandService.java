package com.pugliatti.andrea.retrofocus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.Brand;
import com.pugliatti.andrea.retrofocus.repository.BrandRepository;

@Service
public class BrandService {
    private BrandRepository repo;

    public BrandService(BrandRepository brandRepository) {
        this.repo = brandRepository;
    }

    public List<Brand> findAll() {
        return repo.findAll();
    }

}
