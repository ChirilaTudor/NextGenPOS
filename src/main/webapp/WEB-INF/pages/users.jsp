<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">

<div class="container">
  <div class="row">
    <div class="col">Username</div>
    <div class="col">First Name</div>
    <div class="col">Last Name</div>
    <div class="col">Phone Number</div>
    <div class="col">Type Employee</div>
    <div class="col"> Status </div>
  </div>
  <c:forEach var="user" items="${users}">
  <div class="row">
  <div class="col">${user.username}</div>
  <div class="col">${user.person.firstName}</div>
  <div class="col">${user.person.lastName}</div>
  <div class="col">${user.person.getPhonenumber}</div>
  <div class="col">${user.typeEmployee}</div>
  <div class="col">${user.getActive() ? "Active" : " Inactive" } </div>
         <div class="col">
      <a class="btn btn-secondary"
         href="${pageContext.request.contextPath}/EnableUser?id=${user.getIdUser()}" role="button">Enable
        User</a>
    </div>
    <div class="col">
      <a class="btn btn-secondary"
         href="${pageContext.request.contextPath}/DisableUser?id=${user.getIdUser()}" role="button">
        Disable User</a>
    </div>

  </div>
    </c:forEach>
    </div>


</t:pageTemplate>