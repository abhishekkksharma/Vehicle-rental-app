package com.rental.main;

import com.rental.service.*;

import java.util.Scanner;

public class RentalApp {

    public static void main(String[] args) {

        FileService fileService = new FileService();
        RentalService rentalService = new RentalService(fileService);
        ReportService reportService = new ReportService();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- VEHICLE RENTAL SYSTEM ---");
            System.out.println("1. Register Customer");
            System.out.println("2. Show Available Vehicles");
            System.out.println("3. Rent Vehicle");
            System.out.println("4. Return Vehicle");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> rentalService.registerCustomer();
                case 2 -> rentalService.showAvailableVehicles();
                case 3 -> rentalService.rentVehicle();
                case 4 -> rentalService.returnVehicle();
                case 5 -> {
                    System.out.println("Thank You!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}
