package com.example.customerservice.enums;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
