package com.nextgenpos.nextgenpos.servlets;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "Cash", value = "/Cash")
public class Cash extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("money_given") != null) {
            Double moneyGiven = Double.parseDouble(request.getParameter("money_given"));
            Double total = Double.parseDouble(request.getParameter("total"));

            Double change;

            change = moneyGiven - total;

            if(moneyGiven < total)
            {
                change = null;
            }

            request.setAttribute("change", change);
            request.setAttribute("total", total);

            request.getRequestDispatcher("/WEB-INF/pages/cash.jsp").forward(request, response);
        }
        else {
            if(!request.getParameter("total").isEmpty()){
                Double total = Double.parseDouble(request.getParameter("total"));
                request.setAttribute("total", total);

                request.getRequestDispatcher("/WEB-INF/pages/cash.jsp").forward(request, response);
            }
            request.getRequestDispatcher("/WEB-INF/pages/sale.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
