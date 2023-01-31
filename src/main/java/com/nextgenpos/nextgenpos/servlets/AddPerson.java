package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.ejb.PersonsBean;
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
import java.sql.Date;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_PERSONS"}))
@WebServlet(name = "AddPerson", value = "/AddPerson")
public class AddPerson extends HttpServlet {
    @Inject
    PersonsBean personsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addPerson.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long personId = Long.parseLong(request.getParameter("personId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String cnp = request.getParameter("cnp");
        String address = request.getParameter("address");

        String birth = request.getParameter("birthDate");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        long l = 0;
        try {
            l = simpleDateFormat.parse(birth).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date date = new Date(l);

        Integer phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));


        personsBean.createPerson(personId, firstName, lastName, address, cnp, date, phoneNumber);
        response.sendRedirect(request.getContextPath() + "/Users");
    }
}
