package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import com.nextgenpos.nextgenpos.ejb.SalesBean;
import com.nextgenpos.nextgenpos.ejb.ShoppingCartBean;
import com.nextgenpos.nextgenpos.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collection;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CASHIER"}))
@WebServlet(name = "ShoppingCart", value = "/ShoppingCart")
public class ShoppingCart extends HttpServlet {
    @Inject
    ShoppingCartBean shoppingCartBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!shoppingCartBean.getShoppingCart().isEmpty()){
            Collection<ShoppingCartProductDto> shoppingCart = shoppingCartBean.getShoppingCart();
            request.setAttribute("shoppingCart", shoppingCart);

            double totalPrice = 0.0;

            for(ShoppingCartProductDto product : shoppingCart){
                totalPrice += product.getPrice();
            }

            totalPrice = Math.floor(totalPrice * 100) / 100;
            request.setAttribute("totalPrice", totalPrice);
        }
        request.getRequestDispatcher("/WEB-INF/pages/sale.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
