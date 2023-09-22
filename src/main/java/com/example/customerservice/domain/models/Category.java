package com.example.customerservice.domain.models;

public enum Category {
    TREINO("treino"),
    COACH("coach"),
    NUTRICAO("nutricao");

    private String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
