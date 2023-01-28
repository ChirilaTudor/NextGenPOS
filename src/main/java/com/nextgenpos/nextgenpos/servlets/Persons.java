package com.nextgenpos.nextgenpos.servlets;

import com.nextgenpos.nextgenpos.common.PersonDto;
import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.ejb.InvoicePersonBean;
import com.nextgenpos.nextgenpos.ejb.PersonsBean;
import com.nextgenpos.nextgenpos.entities.Person;
import jakarta.annotation.security.DeclareRoles;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@DeclareRoles({"READ_USERS", "WRITE_USERS"})
//@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_USERS"}),
//        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed = {"WRITE_USERS"})})
@WebServlet(name = "Persons", value = "/Persons")
public class Persons extends HttpServlet {

    @Inject
    PersonsBean personsBean;
    @Inject
    InvoicePersonBean invoicePersonBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PersonDto> persons = personsBean.findAllPersons();
        request.setAttribute("persons", persons);

//        if(!invoicePersonBean.getPersonIds().isEmpty()){
//            Collection<String> names = personsBean.findPersonsByPersonIds(invoicePersonBean.getPersonIds());
//            request.setAttribute("invoices", names);
//        }

        request.getRequestDispatcher("/WEB-INF/pages/persons.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] personIdsAsString = request.getParameterValues("person_ids");
        if (personIdsAsString != null) {
            List<Long> personIds = new ArrayList<>();
            for (String personIdAsString : personIdsAsString) {
                personIds.add(Long.parseLong(personIdAsString));
            }
            invoicePersonBean.getPersonIds().addAll(personIds);
        }
        response.sendRedirect(request.getContextPath() + "/Persons");
    }
}

