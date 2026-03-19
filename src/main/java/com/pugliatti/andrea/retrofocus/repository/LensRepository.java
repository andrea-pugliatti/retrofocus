package com.pugliatti.andrea.retrofocus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.model.Mount;

public interface LensRepository extends JpaRepository<Lens, Integer>, JpaSpecificationExecutor<Lens> {
    public List<Lens> findByMount(Mount mount);

    public List<Lens> findByNameContaining(String name);

    public List<Lens> findByNameContainingAndMount(String name, Mount mount);
}
