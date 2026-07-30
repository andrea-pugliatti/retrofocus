package com.pugliatti.andrea.retrofocus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pugliatti.andrea.retrofocus.model.Photographer;

public interface PhotographerRepository extends JpaRepository<Photographer, Integer> {
    public List<Photographer> findByNameContaining(String name);
}