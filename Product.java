package com.example.ec.model;

public class Product {
    private int id;
    private String name;
    private int stockQuantity;
    private String location;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
