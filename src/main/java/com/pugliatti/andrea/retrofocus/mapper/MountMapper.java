package com.pugliatti.andrea.retrofocus.mapper;

import com.pugliatti.andrea.retrofocus.dto.MountDTO;
import com.pugliatti.andrea.retrofocus.model.Camera;
import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.model.Mount;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MountMapper {

    public MountDTO toDTO(Mount mount) {
        if (mount == null) {
            return null;
        }

        List<Integer> cameraIds = mount.getCameras() == null ? null :
            mount.getCameras().stream()
                .map(Camera::getId)
                .collect(Collectors.toList());

        List<Integer> lensIds = mount.getLenses() == null ? null :
            mount.getLenses().stream()
                .map(Lens::getId)
                .collect(Collectors.toList());

        return new MountDTO(
            mount.getId(),
            mount.getName(),
            mount.getDescription(),
            cameraIds,
            lensIds
        );
    }

    public void updateEntity(MountDTO dto, Mount mount) {
        if (dto == null || mount == null) {
            return;
        }

        mount.setName(dto.name());
        mount.setDescription(dto.description());
    }
}
