package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Inventory", value = "/Inventory")
public class Inventory extends HttpServlet {
    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDto> inventory = productsBean.findAllProducts();
        request.setAttribute("inventory", inventory);
        request.getRequestDispatcher("/WEB-INF/pages/inventory.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] productIdsAsString = request.getParameterValues("inventory_ids");
        if(productIdsAsString != null){
            List<Long> productsIds = new ArrayList<>();
            for(String productIdAsString : productIdsAsString){
                productsIds.add(Long.parseLong(productIdAsString));
            }
            productsBean.deleteProductsByIds(productsIds);
        }
        response.sendRedirect(request.getContextPath() + "/Inventory");
    }
}
