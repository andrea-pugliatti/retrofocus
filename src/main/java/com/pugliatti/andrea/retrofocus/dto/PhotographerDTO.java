package com.pugliatti.andrea.retrofocus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public record PhotographerDTO(
    Integer id,
    @NotBlank(message = "The name must not be blank or null.")
    @Size(
        min = 2,
        max = 50,
        message = "The name must be between 2 and 50 characters."
    )
    String name,
    @Size(max = 70, message = "The image url must be at most 70 characters.")
    String image,
    @Past(message = "The birthday must be in the past.")
    @NotNull(message = "The birthday must be inserted.")
    LocalDate birthday,
    String biography,
    List<CameraDTO> cameras,
    List<LensDTO> lenses
) {}
