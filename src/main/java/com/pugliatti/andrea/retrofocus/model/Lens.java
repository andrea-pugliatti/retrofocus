package com.pugliatti.andrea.retrofocus.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "lenses")
public class Lens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The name must not be blank or null.")
    private String name;

    @Lob
    private String description;

    @PastOrPresent(message = "The year of release must be in the past.")
    private LocalDate yearReleased;

    @Positive(message = "The minimum focal length must be a positive value.")
    private Integer minFocalLength;

    @Positive(message = "The maximum focal length must be a positive value.")
    private Integer maxFocalLength;

    @Positive(message = "The minimum aperture must be a positive value.")
    private Double minAperture;

    @Positive(message = "The maximum aperture must be a positive value.")
    private Double maxAperture;

    @NotNull(message = "The field must not be null.")
    private Boolean isAutofocus;

    @ManyToOne
    @JoinColumn(name = "mount_id", nullable = false)
    @JsonBackReference
    private Mount mount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(LocalDate yearReleased) {
        this.yearReleased = yearReleased;
    }

    public Integer getMinFocalLength() {
        return minFocalLength;
    }

    public void setMinFocalLength(Integer minFocalLength) {
        this.minFocalLength = minFocalLength;
    }

    public Integer getMaxFocalLength() {
        return maxFocalLength;
    }

    public void setMaxFocalLength(Integer maxFocalLength) {
        this.maxFocalLength = maxFocalLength;
    }

    public Double getMinAperture() {
        return minAperture;
    }

    public void setMinAperture(Double minAperture) {
        this.minAperture = minAperture;
    }

    public Double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(Double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public Boolean getIsAutofocus() {
        return isAutofocus;
    }

    public void setIsAutofocus(Boolean isAutofocus) {
        this.isAutofocus = isAutofocus;
    }

    public Mount getMount() {
        return mount;
    }

    public void setMount(Mount mount) {
        this.mount = mount;
    }
}
