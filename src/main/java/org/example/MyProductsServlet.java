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
    HttpSession session = req.getSession();
        if(session==null || session.getAttribute("userName")==null){
            res.getWriter().println("Not logged In please login first");
        }
        else{
            String username = (String) session.getAttribute("userName");

            List<Product> products;
            res.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            Gson gson = new Gson();
            out.print(gson.toJson(products));
            out.flush();
        }
        }

    }


}
