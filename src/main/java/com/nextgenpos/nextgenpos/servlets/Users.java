package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.ejb.ProductsBean;
import com.nextgenpos.nextgenpos.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
//TODO: Verify servlets for diasble/enable + error on isActive DTO
    @Inject
    UsersBean usersBean;
    private static final Logger LOG = Logger.getLogger(Users.class.getName());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    List<UserDto> users= usersBean.findAllUsers();
        request.setAttribute("users",users);
    request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
