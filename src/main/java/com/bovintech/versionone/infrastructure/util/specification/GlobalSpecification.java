package com.bovintech.versionone.infrastructure.util.specification;

import com.bovintech.versionone.infrastructure.inspector.adapter.model.entity.InspectorEntity;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;

public class GlobalSpecification {
    public static <T> Specification<T> hasAttribute(String attribute, String fieldName) {
        return (root, query, criteriaBuilder) -> {
            if (attribute == null || attribute.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return criteriaBuilder.equal(root.get(fieldName), attribute);
        };
    }
}
