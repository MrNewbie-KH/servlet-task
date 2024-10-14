package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

//Servlet for adding products (path: catalog/products method: post)
// and listing all products (path: catalog/products method: get)
@WebServlet("/catalog/products")
public class AllProductsServlet extends HttpServlet {
    List<Product> products =RepositoryProducts.getProducts();
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       req.setAttribute("products", products);
       req.getRequestDispatcher("/products.jsp").include(req, res);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String productPriceStr = req.getParameter("productPrice");

        if (productName == null || productName.isEmpty() || productPriceStr == null || productPriceStr.isEmpty()) {
            req.setAttribute("errorMessage", "Product name or price cannot be empty.");
            req.getRequestDispatcher("/addProduct.jsp").forward(req, res);
            return;
        }

        double productPrice;
        try {
            productPrice = Double.parseDouble(productPriceStr);
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid product price.");
            req.getRequestDispatcher("/addProduct.jsp").forward(req, res);
            return;
        }
        String userName = (String)req.getSession().getAttribute("userName");
        RepositoryProducts.addProduct(new Product(productName,productPrice,userName));
        req.setAttribute("products", products);
        req.getRequestDispatcher("/products.jsp").forward(req, res);
    }
}
