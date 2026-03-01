package com.pugliatti.andrea.retrofocus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pugliatti.andrea.retrofocus.model.Camera;

public interface CameraRepository extends JpaRepository<Camera, Integer> {

}
