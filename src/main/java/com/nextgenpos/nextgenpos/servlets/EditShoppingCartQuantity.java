package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
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
    ShoppingCartBean shoppingCartBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId =  Long.parseLong(request.getParameter("product_id"));


        if (request.getParameter("up") != null) {
            shoppingCartBean.editProductQuantityInShoppingCart(productId, "up");

        } else if (request.getParameter("down") != null) {
            shoppingCartBean.editProductQuantityInShoppingCart(productId, "down");
        }

        response.sendRedirect(request.getContextPath() + "/ShoppingCart");
    }
}
