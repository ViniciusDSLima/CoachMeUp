package com.example.coachMeUp.enums;

public enum CustomerRole {
    CUSTOMER("customer");

    private String role;

    CustomerRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
