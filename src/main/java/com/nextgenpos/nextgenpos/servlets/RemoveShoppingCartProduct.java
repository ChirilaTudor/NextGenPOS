package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.ShoppingBean;
import com.nextgenpos.nextgenpos.ejb.ShoppingCartBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CASHIER"}))
@WebServlet(name = "RemoveShoppingCartProduct", value = "/RemoveShoppingCartProduct")
public class RemoveShoppingCartProduct extends HttpServlet {
    @Inject
    ShoppingBean shoppingBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId =  Long.parseLong(request.getParameter("product_id"));
        shoppingBean.removeProductFromShoppingCart(productId);

        response.sendRedirect(request.getContextPath() + "/ShoppingCart");
    }
}
