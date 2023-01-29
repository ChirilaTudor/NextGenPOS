<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="NextGenPOS">
<div class="row row-cols-3 g-2 " id="main">
  <c:forEach var="product" items="${products}">
      <div class="<d-flex align-items-center col " style="width: 20rem;" >
        <div class="card p-3">
          <div class="d-flex justify-content-between align-items-center ">
            <div class="mt-3">
              <h5>Furnizor: ${product.provider}</h5>
              <div class="mt-1">
                <h6 class="main-heading mt-0">Nume: ${product.productName}</h6>
              </div>
            </div>
            <div class="image">
              <img src="https://i.imgur.com/MGorDUi.png" width="80">
            </div>
          </div>
          <div>
            <p>Descriere: ${product.description}</p>
            <h6>Pret: ${product.price} lei</h6>
          </div>

        </div>
      </div>
  </c:forEach>
  </div>
</t:pageTemplate>






