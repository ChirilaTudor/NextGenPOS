package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.SalesBean;
import com.nextgenpos.nextgenpos.ejb.ShoppingCartBean;
import com.nextgenpos.nextgenpos.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "Sale", value = "/Sale")
public class Sale extends HttpServlet {

    @Inject
    ShoppingCartBean shoppingCartBean;

    @Inject
    SalesBean salesBean;

    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getUserPrincipal().getName();
        Long userId = usersBean.getIdByUsername(username);

        salesBean.createSale(userId);
        shoppingCartBean.removeAllProductsFromShoppingCart();
        response.sendRedirect(request.getContextPath() + "/ShoppingCart");
    }

}
