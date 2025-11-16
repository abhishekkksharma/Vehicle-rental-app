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

    public void registerCustomer() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        String id = sc.nextLine();

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

    public void rentVehicle() {
        Scanner sc = new Scanner(System.in);

        showAvailableVehicles();

        System.out.print("\nEnter Vehicle ID to Rent: ");
        String id = sc.nextLine();

        System.out.print("Enter Days: ");
        int days = sc.nextInt();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id) && v.isAvailable()) {
                v.setAvailable(false);

                double total = v.getRentPerDay() * days;
                System.out.println("\nRent Successful! Total Amount = ₹" + total);

                fileService.saveVehicles("vehicles.csv", vehicles);
                return;
            }
        }

        System.out.println("Invalid Vehicle ID or Not Available.");
    }

    public void returnVehicle() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle ID to Return: ");
        String id = sc.nextLine();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id) && !v.isAvailable()) {
                v.setAvailable(true);

                fileService.saveVehicles("vehicles.csv", vehicles);
                System.out.println("Vehicle Returned Successfully!");
                return;
            }
        }

        System.out.println("Invalid Vehicle ID.");
    }
}
