package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.CategoryDto;
import com.nextgenpos.nextgenpos.ejb.CategoryBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Categories", value = "/Categories")
public class Categories extends HttpServlet {
    @Inject
    CategoryBean categoryBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryDto> categories = categoryBean.findAllCategories();

        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/pages/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
