package com.pugliatti.andrea.retrofocus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pugliatti.andrea.retrofocus.model.Photographer;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Integer> {
    public List<Photographer> findByNameContaining(String name);
}