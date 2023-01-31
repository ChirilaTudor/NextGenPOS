package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import com.nextgenpos.nextgenpos.ejb.ReportsBean;
import com.nextgenpos.nextgenpos.entities.Product;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateProductReport", value = "/CreateProductReport")
public class CreateProductReport extends HttpServlet {
    @Inject
    ReportsBean reportsBean;
    @Inject
    ProductsBean productsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idProduct = Long.parseLong(request.getParameter("idProduct"));
        ProductDto productDto = productsBean.findById(idProduct);
        reportsBean.createProductReport(productDto);
        response.sendRedirect(request.getContextPath() + "/StockReport");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
