package com.bovintech.versionone.infrastructure.certification.adapter.specification;

import com.bovintech.versionone.infrastructure.certification.adapter.model.entity.CertificationEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CertificationSpecification {

    public static Specification<CertificationEntity> hasInspectors(List<String> inspectors) {
        return (root, query, criteriaBuilder) -> {
            if (inspectors == null || inspectors.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return root.get("inspector").get("username").in(inspectors);
        };
    }

}
