package com.example.coachMeUp.enums;

public enum MensagemCustomer {

    CUSTOMER_NAO_ENCONTRADO("customer not found");

    private String description;

    MensagemCustomer(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
