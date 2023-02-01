package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.SearchBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchBar", value = "/SearchBar")
public class SearchBar extends HttpServlet {

    @Inject
    SearchBean searchBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("text_search");
        List<ProductDto> products = searchBean.searchProductsByName(searchText);

        request.setAttribute("products", products);

        if (request.getParameter("viewer") != null) {
            request.getRequestDispatcher("/WEB-INF/pages/viewer.jsp").forward(request, response);

        } else if (request.getParameter("productList") != null) {
            request.getRequestDispatcher("/WEB-INF/pages/productList.jsp").forward(request, response);

        } else if (request.getParameter("inventory") != null) {
            request.getRequestDispatcher("/WEB-INF/pages/inventory.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
