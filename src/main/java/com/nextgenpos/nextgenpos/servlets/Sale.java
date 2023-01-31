package com.nextgenpos.nextgenpos.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "Sale", value = "/Sale")
public class Sale extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name="car";
        request.setAttribute("name", name);
        int nr= 4;
        request.setAttribute("nr", nr);
        double price=200.0;
        request.setAttribute("price", price);
        request.getRequestDispatcher("/WEB-INF/pages/sale.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
