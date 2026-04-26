package com.pugliatti.andrea.retrofocus.mapper;

import com.pugliatti.andrea.retrofocus.dto.CameraDTO;
import com.pugliatti.andrea.retrofocus.dto.LensDTO;
import com.pugliatti.andrea.retrofocus.dto.PhotographerDTO;
import com.pugliatti.andrea.retrofocus.model.Photographer;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class PhotographerMapper {

    private final CameraMapper cameraMapper;
    private final LensMapper lensMapper;

    public PhotographerMapper(
        CameraMapper cameraMapper,
        LensMapper lensMapper
    ) {
        this.cameraMapper = cameraMapper;
        this.lensMapper = lensMapper;
    }

    public PhotographerDTO toDto(Photographer entity) {
        if (entity == null) {
            return null;
        }

        List<CameraDTO> cameras =
            entity.getCameras() == null
                ? null
                : entity
                      .getCameras()
                      .stream()
                      .map(cameraMapper::toDto)
                      .collect(Collectors.toList());

        List<LensDTO> lenses =
            entity.getLenses() == null
                ? null
                : entity
                      .getLenses()
                      .stream()
                      .map(lensMapper::toDto)
                      .collect(Collectors.toList());

        return new PhotographerDTO(
            entity.getId(),
            entity.getName(),
            entity.getImage(),
            entity.getBirthday(),
            entity.getBiography(),
            cameras,
            lenses
        );
    }

    public Photographer toEntity(PhotographerDTO dto) {
        if (dto == null) {
            return null;
        }

        Photographer entity = new Photographer();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setImage(dto.image());
        entity.setBirthday(dto.birthday());
        entity.setBiography(dto.biography());
        return entity;
    }
}
