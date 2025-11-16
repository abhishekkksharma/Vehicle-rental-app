package com.rental.model;

public class Bike extends Vehicle {

    public Bike(String id, String model, double rent, boolean available) {
        super(id, model, rent, available);
    }

    @Override
    public String getType() {
        return "Bike";
    }
}
