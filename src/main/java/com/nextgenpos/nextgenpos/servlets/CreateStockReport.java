package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.ReportsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"GENERAL_DIRECTOR"}))
@WebServlet(name = "CreateStockReport", value = "/CreateStockReport")
public class CreateStockReport extends HttpServlet {

    @Inject
    ReportsBean reportsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    reportsBean.createStockReport();
        response.sendRedirect(request.getContextPath() + "/StockReport");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
