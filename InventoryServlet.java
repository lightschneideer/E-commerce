package com.example.ec.servlet;

import com.example.ec.service.InventoryService;
import com.example.ec.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet {
    private InventoryService inventoryService = new InventoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("product_id");
        if (productId != null) {
            Product product = inventoryService.getProductById(Integer.parseInt(productId));
            request.setAttribute("product", product);
            request.getRequestDispatcher("jsp/inventory.jsp").forward(request, response);
        } else {
            List<Product> products = inventoryService.getAllProducts();
            request.setAttribute("products", products);
            request.getRequestDispatcher("jsp/inventory.jsp").forward(request, response);
        }
    }
}
