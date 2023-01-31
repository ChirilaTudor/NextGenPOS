package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import com.nextgenpos.nextgenpos.ejb.ReportsBean;
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDto productDto = new ProductDto(Long.parseLong("1"),"productName",2,2.0,"NVM","SIAOMI");
        reportsBean.createProductReport(productDto);
        response.sendRedirect(request.getContextPath() + "/StockReport");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
