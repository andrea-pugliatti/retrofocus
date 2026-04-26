package com.pugliatti.andrea.retrofocus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record CameraDTO(
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
    @NotNull(message = "The year of release must be inserted.")
    LocalDate yearReleased,
    @PastOrPresent(message = "The year of discontinuation must be in the past.")
    LocalDate yearDiscontinued,
    @Size(max = 30, message = "The camera type must be at most 30 characters.")
    @NotBlank(message = "The type must not be blank or null.")
    String type,
    @Size(
        max = 30,
        message = "The camera format must be at most 30 characters."
    )
    @NotBlank(message = "The format must not be blank or null.")
    String format,
    @Size(
        max = 30,
        message = "The shutter speed field must be at most 30 characters."
    )
    String minShutterSpeed,
    @Size(
        max = 30,
        message = "The shutter speed field must be at most 30 characters."
    )
    String maxShutterSpeed,
    Integer mountId
) {}
