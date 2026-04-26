package com.pugliatti.andrea.retrofocus.repository.specification;

import com.pugliatti.andrea.retrofocus.model.Camera;
import org.springframework.data.jpa.domain.PredicateSpecification;

public final class CameraSpecifications {

    private CameraSpecifications() {}

    public static PredicateSpecification<Camera> hasName(String name) {
        return (from, builder) ->
            (name == null || name.isBlank())
                ? null
                : builder.like(from.get("name"), "%" + name + "%");
    }

    public static PredicateSpecification<Camera> hasMount(Integer mountId) {
        return (from, builder) ->
            mountId == null
                ? null
                : builder.equal(from.get("mount").get("id"), mountId);
    }
}
