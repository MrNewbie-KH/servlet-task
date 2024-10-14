package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//Servlet for listing products created by the logged-in user
// (path: catalog/my-products method: get)
@WebServlet("/catalog/my-products")
public class MyProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Product> products = RepositoryProducts.getProducts();
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("user");

                List<Product> myProducts = products.stream()
                        .filter(p -> p.getCreatedBy().equals(username))
                        .collect(Collectors.toList());

                req.setAttribute("myProducts", myProducts);
                req.getRequestDispatcher("/my-products.jsp").forward(req, res);
            }
        }
