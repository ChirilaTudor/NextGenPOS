package com.nextgenpos.nextgenpos.servlets;

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

@WebServlet(name = "StockReport", value = "/StockReport")
public class StockReport extends HttpServlet {

    @Inject
    ReportsBean reportBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<String> reports=   reportBean.findAllStockReports();
    List<List<String>> listReportsData = new ArrayList<>() ;
        for (String r :
                reports) {
            String[] reportData = r.split("\n");
            List<String> reportDataList = Arrays.stream(reportData).collect(Collectors.toList());
            listReportsData.add(reportDataList);
        }

    request.setAttribute("listReportsData",listReportsData);
    request.getRequestDispatcher("/WEB-INF/pages/reportsStock.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
