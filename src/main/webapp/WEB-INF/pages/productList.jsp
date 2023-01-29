<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="ProductList">
<div class="row row-cols-3 g-3" id="main">
  <c:forEach var="product_list" items="${products_list}">
  <div class="<d-flex align-items-center col" style="width: 20rem;" >
    <div class="card p-4">
      <div class="d-flex justify-content-between align-items-center ">
        <div class="mt-3">
          <h5>${product_list.provider}</h5>
          <div class="mt-3">
            <h5 class="main-heading mt-0 text-uppercase">${product_list.productName}</h5>
          </div>
        </div>
        <div class="image">
          <img src="https://i.imgur.com/MGorDUi.png" width="70">
        </div>
      </div>
      <div class="pt-1">
        <h5>${product_list.quantity}</h5>
      </div>
      </div>
  </div>
  </c:forEach>
</div>
</t:pageTemplate>