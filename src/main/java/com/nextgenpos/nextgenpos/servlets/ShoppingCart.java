package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import com.nextgenpos.nextgenpos.ejb.SalesBean;
import com.nextgenpos.nextgenpos.ejb.ShoppingCartBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "ShoppingCart", value = "/ShoppingCart")
public class ShoppingCart extends HttpServlet {
    @Inject
    ShoppingCartBean shoppingCartBean;

    @Inject
    SalesBean salesBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!shoppingCartBean.getShoppingCart().isEmpty()){
            Collection<ShoppingCartProductDto> shoppingCart = shoppingCartBean.getShoppingCart();
            request.setAttribute("shoppingCart", shoppingCart);

            double totalPrice = 0.0;

            for(ShoppingCartProductDto product : shoppingCart){
                totalPrice += (product.getPrice() * product.getQuantity());
            }
            request.setAttribute("totalPrice", totalPrice);
        }
        request.getRequestDispatcher("/WEB-INF/pages/shoppingCart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("user_id"));
        salesBean.createSale(userId);
        shoppingCartBean.removeAllProductsFromShoppingCart();
        response.sendRedirect(request.getContextPath() + "/ShoppingCart");
    }
}
