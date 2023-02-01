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

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"GENERAL_DIRECTOR"}))
@WebServlet(name = "EditProduct", value = "/EditProduct")
public class EditProduct extends HttpServlet {

    @Inject
    ProductsBean productsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("id"));
        ProductDto product = productsBean.findById(productId);
        request.setAttribute("product", product);


        request.getRequestDispatcher("/WEB-INF/pages/editProduct.jsp").forward(request, response);
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("person_id"));
        String productName = request.getParameter("product_name");
        Integer quantity = Integer.parseInt(request.getParameter("product_quantity"));
        Double price = Double.parseDouble(request.getParameter("product_price"));
        String description = request.getParameter("product_description");
        String provider = request.getParameter("product_provider");

        productsBean.updateProduct(productId, productName, quantity, price, description, provider);

        response.sendRedirect(request.getContextPath() + "/EditableProducts");
    }

}
