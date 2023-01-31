package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import com.nextgenpos.nextgenpos.ejb.ShoppingCartBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddShoppingCartProduct", value = "/AddShoppingCartProduct")
public class AddShoppingCartProduct extends HttpServlet {

    @Inject
    ShoppingCartBean shoppingCartBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("product_id"));
        shoppingCartBean.addProductIntoShoppingCart(productId);
        response.sendRedirect(request.getContextPath() + "/ShoppingCart");
    }
}
