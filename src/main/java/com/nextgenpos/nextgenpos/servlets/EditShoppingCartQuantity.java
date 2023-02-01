package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import com.nextgenpos.nextgenpos.ejb.ShoppingBean;
import com.nextgenpos.nextgenpos.ejb.ShoppingCartBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditShoppingCartQuantity", value = "/EditShoppingCartQuantity")
public class EditShoppingCartQuantity extends HttpServlet {

    @Inject
    ShoppingBean shoppingBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId =  Long.parseLong(request.getParameter("product_id"));

        if (request.getParameter("up") != null) {
            shoppingBean.editProductQuantityInShoppingCart(productId, "up");

        } else if (request.getParameter("down") != null) {
            shoppingBean.editProductQuantityInShoppingCart(productId, "down");
        }

        response.sendRedirect(request.getContextPath() + "/ShoppingCart");
    }
}
