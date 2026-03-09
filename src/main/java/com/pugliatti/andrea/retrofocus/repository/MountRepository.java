package com.pugliatti.andrea.retrofocus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pugliatti.andrea.retrofocus.model.Mount;

public interface MountRepository extends JpaRepository<Mount, Integer> {
    public List<Mount> findByNameContaining(String name);
}
