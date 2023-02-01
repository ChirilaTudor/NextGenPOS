<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Product List">
  <div class="d-flex justify-content-center my-3">
    <h3 id="product_name">Product list</h3>
  </div>

  <div class="input-group d-flex justify-content-end mt-2">
    <div class="searchbar bg-dark">
      <input class="search_input" type="text" name="" placeholder="Search...">
      <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
    </div>
  </div>

<div class="row row-cols-3 g-2 mt-3" id="products">
  <c:forEach var="product" items="${products_list}">
  <div class="<d-flex align-items-center col" style="width: 20rem;" >
    <div class="card p-4">
      <div class="d-flex justify-content-between align-items-center ">
        <div class="mt-3">
          <p class="fs-5 fw-bold overtext">Nume: ${product.productName}</p>

          <div class="mt-1">
            <h6>Stoc: ${product.quantity} bucati</h6>
          </div>
        </div>
        <div class="image">
          <img src="${pageContext.request.contextPath}/ProductPhotos?id=${product.idProduct}" width="70"/>
        </div>
      </div>
      <div class="pt-1">
        <p>Id: ${product.idProduct}</p>
        <p>Furnizor: ${product.provider}</p>
      </div>
      </div>
  </div>
  </c:forEach>
</div>
</t:pageTemplate>