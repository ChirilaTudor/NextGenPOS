<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pageTemplate pageTitle="Persons">
  <h1>Persons</h1>
  <form method="POST" action="${pageContext.request.contextPath}/Persons">
    <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
      <a href="${pageContext.request.contextPath}/AddPerson" class="to btn btn-primary btn-lg">Add Person</a>
<%--      <button class="btn btn-secondary" type="submit">Invoice</button>--%>
    </c:if>
    <div class="container text-center">
      <c:forEach var="person" items="${persons}">
        <div class="row">
<%--          <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">--%>
<%--            <div class="col">--%>
<%--              <input type="checkbox" name="person_ids" value="${person.idPerson}"/>--%>
<%--            </div>--%>
<%--          </c:if>--%>
          <div class="col">
              ${person.firstName}
              ${person.lastName}
          </div>
        </div>
      </c:forEach>
    </div>
  </form>
</t:pageTemplate>