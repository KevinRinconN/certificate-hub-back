package com.bovintech.versionone.domain.season.model;

import com.bovintech.versionone.domain.util.dto.PaginationParams;
import lombok.Getter;

@Getter
public class SeasonSearchParams extends PaginationParams {
    private String name;

    public SeasonSearchParams(String name,  int page, int size, String sort) {
        super(page, size, sort);
        this.name = name;
    }
}
