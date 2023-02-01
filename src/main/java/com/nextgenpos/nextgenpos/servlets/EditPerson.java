package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.PersonDto;
import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import com.nextgenpos.nextgenpos.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "EditPerson", value = "/EditPerson")
public class EditPerson extends HttpServlet {
    @Inject
    UsersBean usersBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        UserDto user = usersBean.findById(userId);

        Long personId = usersBean.findPersonIdByUserId(userId);
        PersonDto person = usersBean.findPersonById(personId);

        request.setAttribute("user", user);
        request.setAttribute("person", person);
        request.getRequestDispatcher("/WEB-INF/pages/editPerson.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long personId = Long.parseLong(request.getParameter("person_id"));
        String first_name = request.getParameter("first_name");
        String last_name =request.getParameter("last_name");
        String address = request.getParameter("address");
        String cnp = request.getParameter("cnp");
        String phone_number = request.getParameter("phone_number");

        usersBean.updateUsers(personId,first_name,last_name,address,cnp,phone_number);
        response.sendRedirect(request.getContextPath() + "/ManageUsers");
    }
}
