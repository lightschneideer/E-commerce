package com.example.ec.service;

import com.example.ec.model.*;
import java.util.*;

public class OrderService {
    private static List<Order> mockOrders = new ArrayList<>();

    static {
        Order order = new Order();
        order.setId(1);
        order.setCustomerName("Alice");
        order.setOrderDate(new Date());
        OrderItem item = new OrderItem();
        item.setProductId(1);
        item.setQuantity(2);
        item.setPrice(1200.0);
        order.setItems(Arrays.asList(item));
        mockOrders.add(order);
    }

    public List<Order> getAllOrders() {
        return mockOrders;
    }

    public Order getOrderById(int id) {
        return mockOrders.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }
}
