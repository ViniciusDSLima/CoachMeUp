package com.example.coachMeUp.enums;

public enum StagesPayment {

    PENDING("pending"),
    CONFIRMED("confirmed"),
    REFUSED("refused"),
    REIMBURSEMENT("reimbursement");

    private String description;

    StagesPayment(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
