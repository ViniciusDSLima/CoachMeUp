package com.example.coachMeUp.enums;

public enum TypeNumber {

    HOUSE_NUMBER("house_number"),
    COMERCIAL_NUMBER("comercial_number"),
    CELL_NUMBER("cell_number");

    private String description;

    TypeNumber(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
