package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.ShoppingCartBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RemoveShoppingCartProduct", value = "/RemoveShoppingCartProduct")
public class RemoveShoppingCartProduct extends HttpServlet {
    @Inject
    ShoppingCartBean shoppingCartBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId =  Long.parseLong(request.getParameter("product_id"));
        shoppingCartBean.removeProductFromShoppingCart(productId);

        response.sendRedirect(request.getContextPath() + "/ShoppingCart");
    }
}
