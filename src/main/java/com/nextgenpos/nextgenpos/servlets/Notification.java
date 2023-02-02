package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.NotifyDto;
import com.nextgenpos.nextgenpos.ejb.NotifyBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"GENERAL_DIRECTOR"}))
@WebServlet(name = "Notification", value = "/Notification")
public class Notification extends HttpServlet {
    @Inject
    NotifyBean notifyBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NotifyDto> notifies = notifyBean.getAllNotifies();
        request.setAttribute("notifications",notifies);
        request.getRequestDispatcher("/WEB-INF/pages/notifications.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/notifications.jsp").forward(request, response);
    }
}