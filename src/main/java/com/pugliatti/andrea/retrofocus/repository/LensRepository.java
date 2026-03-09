package com.pugliatti.andrea.retrofocus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.model.Mount;

public interface LensRepository extends JpaRepository<Lens, Integer> {
    public List<Lens> findByMount(Mount mount);
}
