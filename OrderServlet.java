package com.example.ec.servlet;

import com.example.ec.model.Order;
import com.example.ec.model.OrderItem;
import com.example.ec.service.InventoryService;
import com.example.ec.service.OrderService;
import com.example.ec.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    private InventoryService inventoryService = new InventoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("order_id");
        if (orderId != null) {
            Order order = orderService.getOrderById(Integer.parseInt(orderId));
            request.setAttribute("order", order);
            request.getRequestDispatcher("jsp/orderDetails.jsp").forward(request, response);
        } else {
            List<Order> orders = orderService.getAllOrders();
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("jsp/orders.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String orderDateStr = request.getParameter("orderDate");
        String[] productIds = request.getParameterValues("productId");
        String[] quantities = request.getParameterValues("quantity");
        String[] prices = request.getParameterValues("price");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date orderDate;
        try {
            orderDate = sdf.parse(orderDateStr);
        } catch (Exception e) {
            orderDate = new Date();
        }

        List<OrderItem> items = new ArrayList<>();
        boolean stockError = false;
        StringBuilder errorMsg = new StringBuilder();

        for (int i = 0; i < productIds.length; i++) {
            int pid = Integer.parseInt(productIds[i]);
            int qty = Integer.parseInt(quantities[i]);
            double price = Double.parseDouble(prices[i]);
            Product product = inventoryService.getProductById(pid);
            if (product.getStockQuantity() < qty) {
                stockError = true;
                errorMsg.append("Stock insuficiente para ").append(product.getName()).append(". ");
            } else {
                items.add(new OrderItem(){{
                    setProductId(pid); setQuantity(qty); setPrice(price);
                }});
                product.setStockQuantity(product.getStockQuantity() - qty);
            }
        }

        if (stockError) {
            request.setAttribute("error", errorMsg.toString());
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        } else {
            Order order = new Order();
            order.setId(orderService.getNextId());
            order.setCustomerName(customerName);
            order.setOrderDate(orderDate);
            order.setItems(items);
            orderService.addOrder(order);
            request.setAttribute("message", "Orden creada con éxito!");
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        }
    }
}
