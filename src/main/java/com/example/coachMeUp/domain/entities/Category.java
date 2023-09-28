package com.example.coachMeUp.domain.entities;

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
