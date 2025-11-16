package com.rental.model;

public abstract class Vehicle {
    private String vehicleId;
    private String model;
    private double rentPerDay;
    private boolean available;

    public Vehicle(String vehicleId, String model, double rentPerDay, boolean available) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = available;
    }

    public String getVehicleId() { return vehicleId; }
    public String getModel() { return model; }
    public double getRentPerDay() { return rentPerDay; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public abstract String getType();

    public String toCSV() {
        return vehicleId + "," + getType() + "," + model + "," + rentPerDay + "," + available;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + vehicleId + " - " + model + " | ₹" + rentPerDay + "/day | " +
                (available ? "Available" : "Rented");
    }
}
