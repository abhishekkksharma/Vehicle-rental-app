package com.rental.model;

public class Customer {
    private String customerId;
    private String name;
    private String contact;

    public Customer(String id, String name, String contact) {
        this.customerId = id;
        this.name = name;
        this.contact = contact;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getContact() { return contact; }

    public String toCSV() {
        return customerId + "," + name + "," + contact;
    }

    @Override
    public String toString() {
        return customerId + " - " + name + " (" + contact + ")";
    }
}
