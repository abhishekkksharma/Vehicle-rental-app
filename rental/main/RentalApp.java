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
            System.out.println("5. Add New Vehicle");
            System.out.println("6. Remove Vehicle");
            System.out.println("7. Delete Customer");
            System.out.println("8. Generate Report");
            System.out.println("9. Exit");
            System.out.print("Choose: ");

            try {
                int choice = sc.nextInt();
                
                switch (choice) {
                    case 1 -> rentalService.registerCustomer(sc);
                    case 2 -> rentalService.showAvailableVehicles();
                    case 3 -> rentalService.rentVehicle(sc);
                    case 4 -> rentalService.returnVehicle(sc);
                    case 5 -> rentalService.addNewVehicle(sc);
                    case 6 -> rentalService.removeVehicle(sc);
                    case 7 -> rentalService.deleteCustomer(sc);
                    case 8 -> reportService.generateReport(rentalService.getVehicles());
                    case 9 -> {
                        System.out.println("Thank You!");
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input! Please enter a number.");
                sc.nextLine(); // Clear the invalid input
            }
        }
    }
}
