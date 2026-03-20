package com.pugliatti.andrea.retrofocus.repository.specification;

import org.springframework.data.jpa.domain.PredicateSpecification;

import com.pugliatti.andrea.retrofocus.model.Lens;

public final class LensSpecifications {

    private LensSpecifications() {
    }

    public static PredicateSpecification<Lens> hasName(String name) {
        return (from, builder) -> (name == null || name.isBlank())
                ? null
                : builder.like(from.get("name"), "%" + name + "%");
    }

    public static PredicateSpecification<Lens> hasMount(Integer mountId) {
        return (from, builder) -> mountId == null
                ? null
                : builder.equal(from.get("mount").get("id"), mountId);
    }

}
