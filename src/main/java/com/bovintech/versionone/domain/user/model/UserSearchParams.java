package com.bovintech.versionone.domain.user.model;

import com.bovintech.versionone.domain.util.dto.PaginationParams;
import lombok.Getter;

@Getter
public class UserSearchParams extends PaginationParams {
    private String firstnames;
    private String lastnames;
    private String email;

    public UserSearchParams(String firstnames, String lastnames, String email, int page, int size, String sort) {
        super(page, size, sort);
        this.firstnames = firstnames;
        this.lastnames = lastnames;
        this.email = email;
    }
}

