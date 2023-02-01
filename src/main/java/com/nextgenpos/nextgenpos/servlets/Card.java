package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import com.nextgenpos.nextgenpos.ejb.ShoppingCartBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CASHIER"}))
@WebServlet(name = "Card", value = "/Card")
public class Card extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getParameter("total").isEmpty()){
            Double total = Double.parseDouble(request.getParameter("total"));
            request.setAttribute("total", total);

            request.getRequestDispatcher("/WEB-INF/pages/card.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/WEB-INF/pages/sale.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/card.jsp").forward(request, response);
    }
}
