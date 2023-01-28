package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.UsersBean;
import com.nextgenpos.nextgenpos.entities.Person;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

//@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_USERS"}))
@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {
    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userGroups", new String[] {"WRITE_PRODUCTS", "READ_USERS", "WRITE_USERS","WRITE_PERSONS"});
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Long personId = Long.parseLong(request.getParameter("person_id"));
        String typeEmployee = request.getParameter("typeEmployee");
        Boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));
        String[] userGroups = request.getParameterValues("user_groups");
        if (userGroups == null) {
            userGroups = new String[0];
        }
        usersBean.createUser(username, password, personId, typeEmployee, isActive,Arrays.asList(userGroups));
        response.sendRedirect(request.getContextPath() + "/Users");
    }
}

