package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Servlet for adding products (path: catalog/products method: post)
// and listing all products (path: catalog/products method: get)
@WebServlet("/catalog/products")
public class AllProductsServlet extends HttpServlet {
    List<Product> products =RepositoryProducts.getProducts();
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       res.getWriter().println("All products available : ");
       products.forEach((product)->{
            try {
        res.getWriter().println("The product :"+product.getName()+" has a price of "+product.getPrice());

            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        double productPrice= Double.parseDouble(req.getParameter("productPrice"));
        String userName = (String)req.getSession().getAttribute("userName");
        RepositoryProducts.addProduct(new Product(productName,productPrice,userName));
        res.getWriter().println("Product added successfully !!!");
    }
}
