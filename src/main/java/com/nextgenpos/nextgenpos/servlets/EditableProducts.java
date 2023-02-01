package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"GENERAL_DIRECTOR"}))
@WebServlet(name = "EditableProducts", value = "/EditableProducts")
public class EditableProducts extends HttpServlet{
    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDto> products = productsBean.findAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/pages/editProducts.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] productIdsAsString = request.getParameterValues("product_ids");
        if(productIdsAsString != null){
            List<Long> productsIds = new ArrayList<>();
            for(String productIdAsString : productIdsAsString){
                productsIds.add(Long.parseLong(productIdAsString));
            }
            productsBean.deleteProductsByIds(productsIds);
        }
        response.sendRedirect(request.getContextPath() + "/EditableProducts");
    }
}
