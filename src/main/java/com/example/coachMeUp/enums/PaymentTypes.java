package com.example.coachMeUp.enums;

public enum PaymentTypes {
    PAYPAL("paypal"),
    CREDIT_CARD("credit_card"),
    MBWAY("mbway"),

    DEBIT_DIRECT("debit_direct");


    private String description;

    PaymentTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
