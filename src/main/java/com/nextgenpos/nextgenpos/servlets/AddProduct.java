package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.CategoryDto;
import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.CategoryBean;
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
import java.util.List;

//@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_PRODUCTS"}))
@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {

    @Inject
    ProductsBean productsBean;

    @Inject
    CategoryBean categoryBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryDto> categories = categoryBean.findAllCategories();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("product_name");
        Integer quantity = Integer.parseInt(request.getParameter("product_quantity"));
        Double price = Double.parseDouble(request.getParameter("product_price"));
        String description = request.getParameter("product_description");
        String provider = request.getParameter("product_provider");
        Long categoryId = Long.parseLong(request.getParameter("category_id"));

        productsBean.createProductInCategory(productName, quantity, price, description, provider, categoryId);

        response.sendRedirect(request.getContextPath() + "/AddProduct");
    }

}
