package com.pugliatti.andrea.retrofocus.mapper;

import com.pugliatti.andrea.retrofocus.dto.CameraDTO;
import com.pugliatti.andrea.retrofocus.model.Camera;
import com.pugliatti.andrea.retrofocus.model.Mount;
import org.springframework.stereotype.Component;

@Component
public class CameraMapper {

    public CameraDTO toDto(Camera camera) {
        if (camera == null) {
            return null;
        }
        return new CameraDTO(
            camera.getId(),
            camera.getName(),
            camera.getDescription(),
            camera.getImage(),
            camera.getYearReleased(),
            camera.getYearDiscontinued(),
            camera.getType(),
            camera.getFormat(),
            camera.getMinShutterSpeed(),
            camera.getMaxShutterSpeed(),
            camera.getMount() != null ? camera.getMount().getId() : null
        );
    }

    public Camera toEntity(CameraDTO dto, Mount mount) {
        if (dto == null) {
            return null;
        }
        Camera camera = new Camera();
        camera.setId(dto.id());
        camera.setName(dto.name());
        camera.setDescription(dto.description());
        camera.setImage(dto.image());
        camera.setYearReleased(dto.yearReleased());
        camera.setYearDiscontinued(dto.yearDiscontinued());
        camera.setType(dto.type());
        camera.setFormat(dto.format());
        camera.setMinShutterSpeed(dto.minShutterSpeed());
        camera.setMaxShutterSpeed(dto.maxShutterSpeed());
        camera.setMount(mount);
        return camera;
    }
}
