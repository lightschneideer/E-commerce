package com.example.ec.service;

import com.example.ec.model.Product;
import java.util.*;

public class InventoryService {
    private static List<Product> mockProducts = new ArrayList<>();

    static {
        Product p1 = new Product(); p1.setId(1); p1.setName("Laptop"); p1.setStockQuantity(10); p1.setLocation("A1");
        Product p2 = new Product(); p2.setId(2); p2.setName("Mouse"); p2.setStockQuantity(50); p2.setLocation("B2");
        mockProducts.add(p1);
        mockProducts.add(p2);
    }

    public List<Product> getAllProducts() {
        return mockProducts;
    }

    public Product getProductById(int id) {
        return mockProducts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
