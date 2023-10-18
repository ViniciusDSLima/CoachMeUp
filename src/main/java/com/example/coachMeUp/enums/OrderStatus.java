package com.example.coachMeUp.enums;

public enum OrderStatus {

    REALIZED("realizado"),
    CONFIRMED("confirmed"),

    CANCELED("canceled"),

    CONCLUED("conclued");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
