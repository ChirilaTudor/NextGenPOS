package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.CategoryBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddCategory", value = "/AddCategory")
public class AddCategory extends HttpServlet {

    @Inject
    CategoryBean categoryBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addCategory.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryName = request.getParameter("category_name");
        categoryBean.createCategory(categoryName);

        response.sendRedirect(request.getContextPath() + "/AddCategory");
    }
}
