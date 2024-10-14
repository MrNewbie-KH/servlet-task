package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//Servlet for login that creates a session
// (path: /login) - valid users may be store in memory
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    Set<String> uniqueUsers = new HashSet<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        if (userName == null || userName.isEmpty()) {
            req.setAttribute("errorMessage", "Please login first!");
            req.getRequestDispatcher("/login.jsp").include(req, res);
            return;
        }
        HttpSession session = req.getSession(false);
        if (uniqueUsers.contains(userName)) {

            session.setAttribute("userName", userName);
            res.getWriter().println("Welcome back! " + userName);
            req.getRequestDispatcher("/catalog/products").forward(req, res);

        } else {
            uniqueUsers.add(userName);
            session.setAttribute("userName", userName);
            res.getWriter().println("You are welcome, " + userName);
            req.getRequestDispatcher("/catalog/products").forward(req, res);
        }
    }

}
