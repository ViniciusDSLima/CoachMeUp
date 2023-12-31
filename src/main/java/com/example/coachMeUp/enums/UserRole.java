package com.example.coachMeUp.enums;

public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    CUSTOMER("customer");

    private String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
