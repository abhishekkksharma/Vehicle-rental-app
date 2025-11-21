package com.rental.service;

import com.rental.model.*;
import java.util.*;

public class RentalService {

    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private FileService fileService;

    public RentalService(FileService fileService) {
        this.fileService = fileService;
        vehicles = fileService.loadVehicles("vehicles.csv");
        customers = fileService.loadCustomers("customers.csv");
    }

    public void registerCustomer(Scanner sc) {
        System.out.print("Enter Customer ID: ");
        String id = sc.next();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        customers.add(new Customer(id, name, contact));
        fileService.saveCustomers("customers.csv", customers);

        System.out.println("Customer Registered Successfully!");
    }

    public void showAvailableVehicles() {
        System.out.println("\nAvailable Vehicles:");
        for (Vehicle v : vehicles)
            if (v.isAvailable()) System.out.println(v);
    }

    public void rentVehicle(Scanner sc) {
        showAvailableVehicles();

        System.out.print("\nEnter Vehicle ID to Rent: ");
        String id = sc.next();

        System.out.print("Enter Customer ID: ");
        String customerId = sc.next();

        System.out.print("Enter Days: ");
        int days = sc.nextInt();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id) && v.isAvailable()) {
                v.setAvailable(false);
                v.setCustomerId(customerId);

                double total = v.getRentPerDay() * days;
                System.out.println("\nRent Successful! Total Amount = ₹" + total);

                fileService.saveVehicles("vehicles.csv", vehicles);
                return;
            }
        }

        System.out.println("Invalid Vehicle ID or Not Available.");
    }

    public void returnVehicle(Scanner sc) {
        System.out.print("Enter Vehicle ID to Return: ");
        String id = sc.next();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id) && !v.isAvailable()) {
                v.setAvailable(true);
                v.setCustomerId("N/A");

                fileService.saveVehicles("vehicles.csv", vehicles);
                System.out.println("Vehicle Returned Successfully!");
                return;
            }
        }

        System.out.println("Invalid Vehicle ID.");
    }

    public void addNewVehicle(Scanner sc) {
        System.out.print("Enter Vehicle ID: ");
        String id = sc.next();
        
        System.out.print("Enter Type (Car/Bike): ");
        String type = sc.next();
        sc.nextLine(); // consume newline

        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Rent per Day: ");
        double rent = sc.nextDouble();

        Vehicle v;
        if (type.equalsIgnoreCase("Car")) {
            v = new Car(id, model, rent, true);
        } else if (type.equalsIgnoreCase("Bike")) {
            v = new Bike(id, model, rent, true);
        } else {
            System.out.println("Invalid Vehicle Type!");
            return;
        }

        vehicles.add(v);
        fileService.saveVehicles("vehicles.csv", vehicles);
        System.out.println("Vehicle Added Successfully!");
    }
    
    public void deleteCustomer(Scanner sc) {
        System.out.print("Enter Customer ID to Delete: ");
        String id = sc.next();

        boolean removed = customers.removeIf(c -> c.getCustomerId().equals(id));

        if (removed) {
            fileService.saveCustomers("customers.csv", customers);
            System.out.println("Customer Deleted Successfully!");
        } else {
            System.out.println("Customer ID not found.");
        }
    }

    public void removeVehicle(Scanner sc) {
        System.out.print("Enter Vehicle ID to Remove: ");
        String id = sc.next();

        boolean removed = vehicles.removeIf(v -> v.getVehicleId().equals(id));

        if (removed) {
            fileService.saveVehicles("vehicles.csv", vehicles);
            System.out.println("Vehicle Removed Successfully!");
        } else {
            System.out.println("Vehicle ID not found.");
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
