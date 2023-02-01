package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.NotificationDto;
import com.nextgenpos.nextgenpos.ejb.NotificationsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Notification", value = "/Notification")
public class Notification extends HttpServlet {
    @Inject
    NotificationsBean notificationsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NotificationDto> notificationDtoList = notificationsBean.findALlNotifications();
        request.setAttribute("notifications",notificationDtoList);
        request.getRequestDispatcher("/WEB-INF/pages/notifications.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/notifications.jsp").forward(request, response);
    }
}