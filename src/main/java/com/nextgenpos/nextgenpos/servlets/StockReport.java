package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.ReportDto;
import com.nextgenpos.nextgenpos.ejb.ReportsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"GENERAL_DIRECTOR"}))
@WebServlet(name = "StockReport", value = "/StockReport")
public class StockReport extends HttpServlet {

    @Inject
    ReportsBean reportBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<ReportDto> reports=   reportBean.findAllStockReports();
    request.setAttribute("reports",reports);
    request.getRequestDispatcher("/WEB-INF/pages/reportsStock.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
