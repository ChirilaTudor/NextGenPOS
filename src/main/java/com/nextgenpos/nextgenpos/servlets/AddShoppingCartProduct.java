package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import com.nextgenpos.nextgenpos.ejb.ShoppingBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddShoppingCartProduct", value = "/AddShoppingCartProduct")
public class AddShoppingCartProduct extends HttpServlet {

    @Inject
    ShoppingBean shoppingBean;

    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("product_id"));

        ProductDto product = productsBean.findById(productId);

        if(product != null){
            shoppingBean.addProductIntoShoppingCart(productId);
        }

        response.sendRedirect(request.getContextPath() + "/ShoppingCart");
    }
}
