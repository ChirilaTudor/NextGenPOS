package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.ejb.NotifyBean;
import com.nextgenpos.nextgenpos.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ADMIN"}))
@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {
    @Inject
    UsersBean usersBean;

    @Inject
    NotifyBean notifyBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userGroups", new String[]{"CASHIER", "GENERAL_DIRECTOR","ADMIN"});
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cnp = request.getParameter("cnp");
        String address = request.getParameter("address");
        String date = request.getParameter("birth_date");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date birthDate = null;
        try {
            birthDate = (Date) dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String phoneNumber = request.getParameter("phone_number");
        String[] userGroup = request.getParameterValues("user_groups");
        if(userGroup == null) {
            userGroup = new String[0];
        }

        UserDto userDto= usersBean.createUser(username, password, cnp, address, birthDate, firstName, lastName, phoneNumber, Arrays.asList(userGroup));
        notifyBean.createNotify(userDto);
        response.sendRedirect(request.getContextPath() + "/AddUser");
    }
}

