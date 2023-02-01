<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
<table class="table table-striped mt-4" onload="isActive()">
  <thead>
  <tr>
      <th scope="col">Username</th>
      <th scope="col">IsActive</th>
      <th scope="col">First name</th>
      <th scope="col">Last name</th>
      <th scope="col">CNP</th>
      <th scope="col">Address</th>
      <th scope="col">Birth date</th>
      <th scope="col">Phone number</th>
      <th scope="col"></th>
  </tr>
  </thead>

  <tbody>
  <c:forEach var="user" items="${users}">
  <tr>
      <td>${user.username}</td>
      <td>${user.getActive()}</td>
      <td>${user.getPerson().getFirstName()}</td>
      <td>${user.getPerson().getLastName()}</td>
      <td>${user.getPerson().getCNP()}</td>
      <td>${user.getPerson().getAddress()}</td>
      <td>${user.getPerson().getBirthDate()}</td>
      <td>${user.getPerson().getPhoneNumber()}</td>
      <c:choose>
          <c:when test="${user.getActive()}" >
              <td><a class="btn btn-danger"  href="${pageContext.request.contextPath}/DisableUser?id=${user.idUser}">Disable</a></td>
          </c:when>
          <c:otherwise>
              <td><a class="btn btn-success"  href="${pageContext.request.contextPath}/EnableUser?id=${user.idUser}">Enable</a></td>
          </c:otherwise>
      </c:choose>

  </tr>
  </c:forEach>
  </tbody>
</table>

</t:pageTemplate>