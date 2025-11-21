# Vehicle Rental System

A simple console-based Java application for managing vehicle rentals. This system allows you to manage customers, vehicles, and rental transactions efficiently.

## Features

- **Customer Management**: Register new customers and delete existing ones.
- **Vehicle Management**: Add new vehicles (Cars/Bikes), remove vehicles, and view available vehicles.
- **Rental Operations**: Rent vehicles to customers and process vehicle returns.
- **Reporting**: Generate reports of current vehicle status.
- **Data Persistence**: All data is saved to `vehicles.csv` and `customers.csv`, ensuring data is not lost between sessions.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure you have Java installed (JDK 8 or higher recommended).
  - Verify installation by running: `java -version` and `javac -version` in your terminal.

## Project Structure

```
Vehicle-rental-app/
├── rental/
│   ├── main/           # Contains the main application entry point (RentalApp.java)
│   ├── model/          # Contains data models (Vehicle, Car, Bike, Customer)
│   └── service/        # Contains business logic (RentalService, FileService, ReportService)
├── bin/                # Compiled bytecode (.class files)
├── vehicles.csv        # Data file for storing vehicle information
├── customers.csv       # Data file for storing customer information
└── README.md           # Project documentation
```

## How to Run

### 1. Compile the Project

Open your terminal or command prompt, navigate to the project root directory (`Vehicle-rental-app`), and run the following command to compile the Java source files. This will place the compiled `.class` files in the `bin` directory.

```bash
javac -d bin rental/model/*.java rental/service/*.java rental/main/*.java
```

### 2. Run the Application

After successful compilation, run the application using the following command:

```bash
java -cp bin com.rental.main.RentalApp
```

## Usage

Once the application is running, follow the on-screen menu instructions:

1.  **Register Customer**: Enter customer details (ID, Name, Contact).
2.  **Show Available Vehicles**: Lists all vehicles currently available for rent.
3.  **Rent Vehicle**: Rent a vehicle by providing Vehicle ID, Customer ID, and duration.
4.  **Return Vehicle**: Return a rented vehicle by providing its Vehicle ID.
5.  **Add New Vehicle**: Add a new Car or Bike to the fleet.
6.  **Remove Vehicle**: Remove a vehicle from the system using its ID.
7.  **Delete Customer**: Remove a registered customer.
8.  **Generate Report**: View a summary of all vehicles.
9.  **Exit**: Close the application.

## Data Files

- **vehicles.csv**: Stores vehicle details (ID, Model, Type, Rent/Day, Availability, CustomerID).
- **customers.csv**: Stores customer details (ID, Name, Contact).

> **Note**: Do not manually alter the CSV headers or structure unless you are sure, as it might affect the application's ability to read data.
