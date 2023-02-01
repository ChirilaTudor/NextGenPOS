package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.CategoryDto;
import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.CategoryBean;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Category", value = "/Category")
public class Category extends HttpServlet {
    @Inject
    ProductsBean productsBean;

    @Inject
    CategoryBean categoryBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long categoryId = Long.parseLong(request.getParameter("idCategory"));
        List<ProductDto> products = productsBean.findProductsByCategory(categoryId);
        CategoryDto category = categoryBean.findById(categoryId);

        request.setAttribute("products", products);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/WEB-INF/pages/viewer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
