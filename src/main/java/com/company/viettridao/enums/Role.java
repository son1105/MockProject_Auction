package com.company.viettridao.enums;

import lombok.Getter;

@Getter
public enum Role {
    BUYER("buyer"),
    BUYERWANTTOBECOMESELLER("buyerwanttobecomeseller"),
    SELLER("seller"),
    ADMIN("admin");
    private final String description;

    Role(String description) {
        this.description = description;
    }
}
