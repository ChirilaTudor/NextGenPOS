<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
<table class="table table-striped">
  <thead>
  <tr>
    <th scope="col">Username</th>
    <th scope="col">Employee Type</th>
    <th scope="col">Active</th>
    <th scope="col">First name</th>
    <th scope="col">Last name</th>
    <th scope="col">CNP</th>
    <th scope="col">Address</th>
    <th scope="col">Birth date</th>
    <th scope="col">Phone number</th>
  </tr>
  </thead>

  <tbody>
  <tr>
    <c:forEach var="user" items="${user}">
      <td>${user.username}</td>
      <td>${user.typeEmployee}</td>
      <td>${user.isActive}</td>
      <td>${user.getPerson().getFirstName()}</td>
      <td>${user.getPerson().getLastName()}</td>
      <td>${user.getPerson().getCNP()}</td>
      <td>${user.getPerson().getAddress()}</td>
      <td>${user.getPerson().getBirthDate()}</td>
      <td>${user.getPerson().getPhoneNumber()}</td>
    </c:forEach>

  </tr>
  </tbody>
</table>

</t:pageTemplate>