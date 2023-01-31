package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.ReturnBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReturnProduct", value = "/ReturnProduct")
public class ReturnProduct extends HttpServlet {

    @Inject
    ReturnBean returnBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/returnProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long itemSaleId = Long.parseLong(request.getParameter("itemSale_id"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        returnBean.returnProducts(itemSaleId, quantity);

        response.sendRedirect(request.getContextPath() + "/ReturnProduct");
    }
}
