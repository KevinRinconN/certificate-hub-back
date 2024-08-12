package com.bovintech.versionone.domain.util.dto;

import java.util.List;

public class Page <T>{
    private List<T> content;
    private Integer totalPages;
    private Integer totalElements;
}
