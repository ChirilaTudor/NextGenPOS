<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Return Product">
  <h1>Test Page</h1>
  <form method="POST" action="${pageContext.request.contextPath}/ReturnProduct">
    <input type="text" id="itemSale_id" name="itemSale_id" class="form-control" placeholder="ItemSale" required autofocus />
    <input type="text" id="quantity" name="quantity" class="form-control" placeholder="Quantity" required autofocus />
    <button class="btn btn-lg btn-primary btn-block" type="submit">Return Product</button>
  </form>
</t:pageTemplate>