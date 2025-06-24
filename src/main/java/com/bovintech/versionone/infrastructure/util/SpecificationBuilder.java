package com.bovintech.versionone.infrastructure.util;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.List;

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

    public SpecificationBuilder<T> withDateRange(String startDate, String endDate, String fieldName) {
        if (startDate != null && !startDate.isEmpty()) {
            if (endDate != null && !endDate.isEmpty()) {
                this.specification = this.specification.and(attributeBetweenDates(startDate, endDate, fieldName));
            } else {
                this.specification = this.specification.and(attributeGreaterThanOrEqualTo(startDate, fieldName));
            }
        } else if (endDate != null && !endDate.isEmpty()) {
            this.specification = this.specification.and(attributeLessThanOrEqualTo(endDate, fieldName));
        }
        return this;
    }

    private Specification<T> attributeEquals(String attribute, String fieldName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.equal(root.get(fieldName), attribute);
    }

    private Specification<T> attributeEqualsInRelatedEntity(String attribute, String relatedEntity, String fieldName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Join<Object, Object> join = root.join(relatedEntity);
            return criteriaBuilder.equal(join.get(fieldName), attribute);
        };
    }

    private Specification<T> attributeLike(String attribute, String fieldName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.like(root.get(fieldName), "%" + attribute + "%");
    }

    private Specification<T> attributeLikeInRelatedEntity(String attribute, String relatedEntity, String fieldName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Join<Object, Object> join = root.join(relatedEntity);
            return criteriaBuilder.like(join.get(fieldName), "%" + attribute + "%");
        };
    }

    private Specification<T> attributeBetweenDates(String startDate, String endDate, String fieldName) {
        return (root, query, criteriaBuilder) -> {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            return criteriaBuilder.between(root.get(fieldName), start, end);
        };
    }

    private Specification<T> attributeGreaterThanOrEqualTo(String startDate, String fieldName) {
        return (root, query, criteriaBuilder) -> {
            LocalDate start = LocalDate.parse(startDate);
            return criteriaBuilder.greaterThanOrEqualTo(root.get(fieldName), start);
        };
    }

    private Specification<T> attributeLessThanOrEqualTo(String endDate, String fieldName) {
        return (root, query, criteriaBuilder) -> {
            LocalDate end = LocalDate.parse(endDate);
            return criteriaBuilder.lessThanOrEqualTo(root.get(fieldName), end);
        };
    }

    public Specification<T> build() {
        return this.specification;
    }
}
