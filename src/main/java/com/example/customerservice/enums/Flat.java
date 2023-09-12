package com.example.customerservice.enums;

public enum Flat {
    PREMIUM("premium"),
    VIP("vip"),
    BASIC("basic");

    private String flat;

    Flat(String flat) {
        this.flat = flat;
    }

    public String getFlat() {
        return flat;
    }
}
