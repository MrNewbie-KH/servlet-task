package org.example;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter("catalog/*")
public class FilterCatalogServlet extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String userName = (String) req.getSession().getAttribute("userName");
        if(userName==null){
            userName="notLogged";
            res.getWriter().println("You must login first");
        }
        chain.doFilter(req, res);
    }
}
