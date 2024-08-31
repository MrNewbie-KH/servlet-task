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
        Set <String> uniqueUsers = new HashSet<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String userName = req.getParameter("userName");
    if(uniqueUsers.contains(userName)) {
    res.getWriter().println("Welcome back! "+ userName);
    }
    else{
    HttpSession session = req.getSession();
    session.setAttribute("userName",userName);
    res.getWriter().println("You are welcome, "+userName);
    uniqueUsers.add(userName);


    }
    }

}
