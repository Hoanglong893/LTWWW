package com.product.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/health")
public class HealthCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/plain; charset=UTF-8");

        response.getWriter().println("✅ Server OK");
        response.getWriter().println("⏰ Time: " + LocalDateTime.now());
        response.getWriter().println("🚀 App is running normally");
    }
}
