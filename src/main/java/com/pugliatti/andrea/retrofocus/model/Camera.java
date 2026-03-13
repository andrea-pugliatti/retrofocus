package com.pugliatti.andrea.retrofocus.model;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cameras")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The name must not be blank or null.")
    @Size(min = 2, max = 70, message = "The name must be between 2 and 70 characters.")
    private String name;

    @Lob
    private String description;

    @URL(message = "Insert a valid url.")
    private String image;

    @PastOrPresent(message = "The year of release must be in the past.")
    @NotNull(message = "The year of release must be inserted.")
    private LocalDate yearReleased;

    @PastOrPresent(message = "The year of discontinuation must be in the past.")
    private LocalDate yearDiscontinued;

    @Size(max = 30, message = "The camera type must be at most 30 characters.")
    @NotBlank(message = "The type must not be blank or null.")
    private String type;

    @Size(max = 30, message = "The camera format must be at most 30 characters.")
    @NotBlank(message = "The format must not be blank or null.")
    private String format;

    @Size(max = 30, message = "The shutter speed field must be at most 30 characters.")
    private String minShutterSpeed;

    @Size(max = 30, message = "The shutter speed field must be at most 30 characters.")
    private String maxShutterSpeed;

    @Positive(message = "The minimum ISO must be a positive value.")
    private Integer minIso;

    @Positive(message = "The maximum ISO must be a positive value.")
    private Integer maxIso;

    @NotNull(message = "The field must not be null.")
    private Boolean isAnalog;

    @Positive(message = "The resolution must be a positive value.")
    private Double sensorResolution;

    @NotNull(message = "The field must not be null.")
    private Boolean videoCapable;

    @ManyToOne
    @JoinColumn(name = "mount_id", nullable = false)
    @JsonBackReference
    private Mount mount;

    @ManyToMany(mappedBy = "cameras", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Photographer> photographers;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(LocalDate yearReleased) {
        this.yearReleased = yearReleased;
    }

    public LocalDate getYearDiscontinued() {
        return yearDiscontinued;
    }

    public void setYearDiscontinued(LocalDate yearDiscontinued) {
        this.yearDiscontinued = yearDiscontinued;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMinShutterSpeed() {
        return minShutterSpeed;
    }

    public void setMinShutterSpeed(String minShutterSpeed) {
        this.minShutterSpeed = minShutterSpeed;
    }

    public String getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(String maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    public Integer getMinIso() {
        return minIso;
    }

    public void setMinIso(Integer minIso) {
        this.minIso = minIso;
    }

    public Integer getMaxIso() {
        return maxIso;
    }

    public void setMaxIso(Integer maxIso) {
        this.maxIso = maxIso;
    }

    public Boolean getIsAnalog() {
        return isAnalog;
    }

    public void setIsAnalog(Boolean isAnalog) {
        this.isAnalog = isAnalog;
    }

    public Boolean getVideoCapable() {
        return videoCapable;
    }

    public void setVideoCapable(Boolean videoCapable) {
        this.videoCapable = videoCapable;
    }

    public Double getSensorResolution() {
        return sensorResolution;
    }

    public void setSensorResolution(Double sensorResolution) {
        this.sensorResolution = sensorResolution;
    }

    public Mount getMount() {
        return mount;
    }

    public void setMount(Mount mount) {
        this.mount = mount;
    }

    public Set<Photographer> getPhotographers() {
        return photographers;
    }

    public void setPhotographers(Set<Photographer> photographers) {
        this.photographers = photographers;
    }
}
