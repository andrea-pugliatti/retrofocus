package com.pugliatti.andrea.retrofocus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record LensDTO(
    Integer id,
    @NotBlank(message = "The name must not be blank or null.")
    @Size(
        min = 2,
        max = 70,
        message = "The name must be between 2 and 70 characters."
    )
    String name,
    String description,
    @Size(max = 70, message = "The image url must be at most 70 characters.")
    String image,
    @PastOrPresent(message = "The year of release must be in the past.")
    LocalDate yearReleased,
    @Positive(message = "The minimum focal length must be a positive value.")
    Integer minFocalLength,
    @Positive(message = "The maximum focal length must be a positive value.")
    Integer maxFocalLength,
    @Positive(message = "The minimum aperture must be a positive value.")
    Double minAperture,
    @Positive(message = "The maximum aperture must be a positive value.")
    Double maxAperture,
    @NotNull(message = "The field must not be null.") Boolean isAutofocus,
    @NotNull(message = "The mount ID must not be null.") Integer mountId
) {}
