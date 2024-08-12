package com.bovintech.versionone.infrastructure.util;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class SpecificationBuilder<T> {
    private Specification<T> specification;
    private static final ComparisonType DEFAULT_COMPARISON_TYPE = ComparisonType.EQUALS; // Valor por defecto

    public SpecificationBuilder() {
        this.specification = (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
    }

    public SpecificationBuilder<T> with(String attribute, String fieldName) {
        return with(attribute, fieldName, DEFAULT_COMPARISON_TYPE);
    }

    public SpecificationBuilder<T> with(String attribute, String fieldName, ComparisonType comparisonType) {
        if (attribute != null && !attribute.isEmpty()) {
            switch (comparisonType) {
                case LIKE:
                    this.specification = this.specification.and(attributeLike(attribute, fieldName));
                    break;
                case EQUALS:
                default:
                    this.specification = this.specification.and(attributeEquals(attribute, fieldName));
                    break;
            }
        }
        return this;
    }

    public SpecificationBuilder<T> withRelated(String attribute, String relatedEntity, String fieldName) {
        return withRelated(attribute, relatedEntity, fieldName, DEFAULT_COMPARISON_TYPE);
    }

    public SpecificationBuilder<T> withRelated(String attribute, String relatedEntity, String fieldName, ComparisonType comparisonType) {
        if (attribute != null && !attribute.isEmpty()) {
            switch (comparisonType) {
                case LIKE:
                    this.specification = this.specification.and(attributeLikeInRelatedEntity(attribute, relatedEntity, fieldName));
                    break;
                case EQUALS:
                default:
                    this.specification = this.specification.and(attributeEqualsInRelatedEntity(attribute, relatedEntity, fieldName));
                    break;
            }
        }
        return this;
    }

    public SpecificationBuilder<T> withRelated(String[] attributes, String relatedEntity, String[] fieldNames) {
        return withRelated(attributes, relatedEntity, fieldNames, DEFAULT_COMPARISON_TYPE);
    }

    public SpecificationBuilder<T> withRelated(String[] attributes, String relatedEntity, String[] fieldNames, ComparisonType comparisonType) {
        if (attributes != null && fieldNames != null && attributes.length == fieldNames.length) {
            for (int i = 0; i < attributes.length; i++) {
                if (attributes[i] != null && !attributes[i].isEmpty()) {
                    switch (comparisonType) {
                        case LIKE:
                            this.specification = this.specification.and(attributeLikeInRelatedEntity(attributes[i], relatedEntity, fieldNames[i]));
                            break;
                        case EQUALS:
                        default:
                            this.specification = this.specification.and(attributeEqualsInRelatedEntity(attributes[i], relatedEntity, fieldNames[i]));
                            break;
                    }
                }
            }
        }
        return this;
    }

    private Specification<T> attributeEquals(String attribute, String fieldName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(fieldName), attribute);
        };
    }

    private Specification<T> attributeEqualsInRelatedEntity(String attribute, String relatedEntity, String fieldName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Join<Object, Object> join = root.join(relatedEntity);
            return criteriaBuilder.equal(join.get(fieldName), attribute);
        };
    }

    private Specification<T> attributeLike(String attribute, String fieldName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(fieldName), "%" + attribute + "%");
        };
    }

    private Specification<T> attributeLikeInRelatedEntity(String attribute, String relatedEntity, String fieldName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Join<Object, Object> join = root.join(relatedEntity);
            return criteriaBuilder.like(join.get(fieldName), "%" + attribute + "%");
        };
    }

    public Specification<T> build() {
        return this.specification;
    }
}
