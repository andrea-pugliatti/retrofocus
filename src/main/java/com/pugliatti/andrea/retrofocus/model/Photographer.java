package com.pugliatti.andrea.retrofocus.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "photographers")
public class Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The name must not be blank or null.")
    @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters.")
    private String name;

    @Size(max = 70, message = "The image url must be at most 70 characters.")
    private String image;

    @Past(message = "The birthday must be in the past.")
    @NotNull(message = "The birthday must be inserted.")
    private LocalDate birthday;

    @Lob
    private String biography;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "camera_photographer", joinColumns = @JoinColumn(name = "photographer_id"), inverseJoinColumns = @JoinColumn(name = "camera_id"))
    private Set<Camera> cameras;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lens_photographer", joinColumns = @JoinColumn(name = "photographer_id"), inverseJoinColumns = @JoinColumn(name = "lens_id"))
    private Set<Lens> lenses;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Set<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(Set<Camera> cameras) {
        this.cameras = cameras;
    }

    public Set<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(Set<Lens> lenses) {
        this.lenses = lenses;
    }
}
