package com.rental.service;

import com.rental.model.Vehicle;
import java.util.*;

public class ReportService {

    public void generateReport(List<Vehicle> list) {
        long available = list.stream().filter(Vehicle::isAvailable).count();
        long rented = list.size() - available;

        System.out.println("\n--- RENTAL REPORT ---");
        System.out.println("Total Vehicles: " + list.size());
        System.out.println("Available: " + available);
        System.out.println("Rented: " + rented);
        
        System.out.println("\n--- RENTED VEHICLES ---");
        for (Vehicle v : list) {
            if (!v.isAvailable()) {
                System.out.println(v.getVehicleId() + " (" + v.getModel() + ") - Rented by: " + v.getCustomerId());
            }
        }
        System.out.println("---------------------");
    }
}
