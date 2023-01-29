package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EnableUser", value = "/EnableUser")
public class EnableUser extends HttpServlet {
    @Inject
    UsersBean usersBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idUser = Long.parseLong(request.getParameter("id"));
        usersBean.enableUser(idUser);
        response.sendRedirect(request.getContextPath() + "/Users");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
