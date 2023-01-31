package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.ReportsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CreateSalesReport", value = "/CreateSalesReport")
public class CreateSalesReport extends HttpServlet {
    @Inject
    ReportsBean reportsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String sDate = "1990-10-10";
       String eDate = "2023-03-10";
        Date startDate;
        Date endDate;
        try {
             startDate = new SimpleDateFormat("yyyy-mm-dd").parse(sDate);
             endDate = new SimpleDateFormat("yyyy-mm-dd").parse(eDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        reportsBean.createSalesReportBetween(startDate,endDate);
        response.sendRedirect(request.getContextPath() + "/StockReport");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
