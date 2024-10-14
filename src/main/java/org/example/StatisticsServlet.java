package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/catalog/stats")
public class StatisticsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Product> products = RepositoryProducts.getProducts();

        int totalProducts = products.size();
        double totalPrice = products.stream().mapToDouble(Product::getPrice).sum();

        req.setAttribute("totalProducts", totalProducts);
        req.setAttribute("totalPrice", totalPrice);
        req.getRequestDispatcher("/servlet_assignment/stats.jsp").forward(req, res);
    }
}
