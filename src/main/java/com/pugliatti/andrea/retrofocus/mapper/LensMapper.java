package com.pugliatti.andrea.retrofocus.mapper;

import com.pugliatti.andrea.retrofocus.dto.LensDTO;
import com.pugliatti.andrea.retrofocus.model.Lens;
import com.pugliatti.andrea.retrofocus.model.Mount;
import org.springframework.stereotype.Component;

@Component
public class LensMapper {

    public LensDTO toDto(Lens lens) {
        if (lens == null) {
            return null;
        }
        return new LensDTO(
            lens.getId(),
            lens.getName(),
            lens.getDescription(),
            lens.getImage(),
            lens.getYearReleased(),
            lens.getMinFocalLength(),
            lens.getMaxFocalLength(),
            lens.getMinAperture(),
            lens.getMaxAperture(),
            lens.getIsAutofocus(),
            lens.getMount() != null ? lens.getMount().getId() : null
        );
    }

    public Lens toEntity(LensDTO dto, Mount mount) {
        if (dto == null) {
            return null;
        }
        Lens lens = new Lens();
        lens.setId(dto.id());
        lens.setName(dto.name());
        lens.setDescription(dto.description());
        lens.setImage(dto.image());
        lens.setYearReleased(dto.yearReleased());
        lens.setMinFocalLength(dto.minFocalLength());
        lens.setMaxFocalLength(dto.maxFocalLength());
        lens.setMinAperture(dto.minAperture());
        lens.setMaxAperture(dto.maxAperture());
        lens.setIsAutofocus(dto.isAutofocus());
        lens.setMount(mount);
        return lens;
    }
}
