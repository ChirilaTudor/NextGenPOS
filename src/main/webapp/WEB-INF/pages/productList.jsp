<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="ProductList">
  <div class="input-group d-flex justify-content-end mt-2">
    <div class="form-outline">
      <input type="search" id="search-input" class="form-control" placeholder="Search"/>
    </div>
    <button id="search-button" type="button" class="btn bg-dark text-white button-margin" onclick="search()">
      <i class="fas fa-search"></i>
    </button>
  </div>
<div class="row row-cols-3 g-2" id="products">
  <c:forEach var="inventory" items="${products_list}">
  <div class="<d-flex align-items-center col" style="width: 20rem;" >
    <div class="card p-4">
      <div class="d-flex justify-content-between align-items-center ">
        <div class="mt-3">
          <h6>Furnizor: ${inventory.provider}</h6>
          <div class="mt-1">
            <h6 class="main-heading">Nume: ${inventory.productName}</h6>
          </div>
        </div>
        <div class="image">
          <img src="https://i.imgur.com/MGorDUi.png" width="70">
        </div>
      </div>
      <div class="pt-1">
        <h6>Stoc: ${inventory.quantity} bucati</h6>
      </div>
      </div>
  </div>
  </c:forEach>
</div>
</t:pageTemplate>