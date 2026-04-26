package com.pugliatti.andrea.retrofocus.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public record MountDTO(
    Integer id,
    @NotBlank(message = "The name must not be blank or null.") String name,
    String description,
    List<Integer> cameraIds,
    List<Integer> lensIds
) {}
