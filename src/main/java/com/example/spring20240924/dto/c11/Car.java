package com.example.spring20240924.dto.c11;

public class Car {
    private String modelName;
    private int price;
    private boolean expired;

    public Car(String modelName, int price, boolean expired) {
        this.modelName = modelName;
        this.price = price;
        this.expired = expired;
    }

    public String getModelName() {
        return modelName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isExpired() {
        return expired;
    }
}