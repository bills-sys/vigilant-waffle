package com.github.billssys.waffle.model.entities;

import com.github.billssys.waffle.model.exceptions.ProductException;

public class Product {

    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(String name, String description, double price, int quantity) throws ProductException {
        if (price < 0.0) {
            throw new ProductException("Price cannot be negative");
        }
        if (quantity < 0) {
            throw new ProductException("Quantity cannot be negative");
        }
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addProduct(int quantity) {
        this.quantity += quantity;
    }

    public void removeProduct(int quantity) throws ProductException {
        if (this.quantity < quantity) {
            throw new ProductException("Insufficient products");
        }
        this.quantity -= quantity;
    }

}
