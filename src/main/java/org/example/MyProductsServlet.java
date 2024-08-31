package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
//Servlet for listing products created by the logged-in user
// (path: catalog/my-products method: get)
@WebServlet("/catalog/my-products")
public class MyProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Product> products = RepositoryProducts.getProducts();
        HttpSession session = req.getSession(false);
        if(session==null || session.getAttribute("userName")==null){
            res.getWriter().println("Not logged In please login first");
        }
        else{
            String username = (String) session.getAttribute("userName");
            if (products != null) {
                products.stream()
                        .filter(product -> username.equals(product.getCreatedBy()))
                        .forEach((product) ->
                        {
                            try {
                                res.getWriter().println(product.toString());
                                return;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        });
            } else {
                res.getWriter().println("No products found.");
            }
        }
        }
}
