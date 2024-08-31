package org.example;
public class Product {
    private String name;
    private double price;
    private String createdBy; // Username of the creator

    public Product(String name, double price, String createdBy) {
        this.name = name;
        this.price = price;
        this.createdBy = createdBy;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
