package com.rental.service;

import com.rental.model.*;
import java.io.*;
import java.util.*;

public class FileService {

    public List<Vehicle> loadVehicles(String fileName) {
        List<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String id = data[0];
                String type = data[1];
                String model = data[2];
                double rent = Double.parseDouble(data[3]);
                boolean avail = Boolean.parseBoolean(data[4]);
                String customerId = (data.length > 5) ? data[5] : "N/A";

                Vehicle vehicle;
                if (type.equals("Car"))
                    vehicle = new Car(id, model, rent, avail);
                else
                    vehicle = new Bike(id, model, rent, avail);
                
                vehicle.setCustomerId(customerId);
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            System.out.println("Error loading vehicles: " + e.getMessage());
        }

        return vehicles;
    }

    public List<Customer> loadCustomers(String fileName) {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                customers.add(new Customer(data[0], data[1], data[2]));
            }

        } catch (Exception e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
        return customers;
    }

    public void saveVehicles(String file, List<Vehicle> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Vehicle v : list) {
                bw.write(v.toCSV());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving vehicles.");
        }
    }

    public void saveCustomers(String file, List<Customer> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Customer c : list) {
                bw.write(c.toCSV());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving customers.");
        }
    }
}
