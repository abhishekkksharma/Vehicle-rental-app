package com.rental.model;

public class Car extends Vehicle {

    public Car(String id, String model, double rent, boolean available) {
        super(id, model, rent, available);
    }

    @Override
    public String getType() {
        return "Car";
    }
}
