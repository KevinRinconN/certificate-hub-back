package com.bovintech.versionone.infrastructure.util.pagination;

import com.bovintech.versionone.infrastructure.util.exceptions.InvalidSortException;
import org.springframework.data.domain.Sort;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class SortUtils {

    public static Sort createSort(String sortParam) {
        if (sortParam == null || sortParam.trim().isEmpty()) {
            return Sort.unsorted();
        }

        return parseSortOrder(sortParam);
    }

    private static Sort parseSortOrder(String sortOrder) {
        String[] parts = sortOrder.split(",");
        String property = parts[0].trim();
        Sort.Direction direction = Sort.Direction.ASC; // Default direction

        if (parts.length == 2) {
            switch (parts[1].trim().toLowerCase()) {
                case "desc":
                    direction = Sort.Direction.DESC;
                    break;
                case "asc":
                    direction = Sort.Direction.ASC;
                    break;
                default:
                    // Handle invalid direction
                    throw new InvalidSortException("Invalid sort direction: " + parts[1]);
            }
        }

        return Sort.by(direction, property);
    }

}
