package org.example;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter("/catalog/*")
public class FilterCatalogServlet extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String userName = (String) req.getSession().getAttribute("userName");

        if (userName == null) {
            req.setAttribute("errorMessage", "You must login first.");
            req.getRequestDispatcher("/login.jsp").forward(req, res);
            return;
        }

        chain.doFilter(req, res);
    }
}
