package com.company.viettridao.models;

import lombok.Getter;

@Getter
public enum AuctionStatus {
    PENDING("pending"),
    ACTIVE("active"),
    ENDED("ended"),
    CANCELLED("cancelled");
    private final String description;

    AuctionStatus(String description) {
        this.description = description;
    }
}
