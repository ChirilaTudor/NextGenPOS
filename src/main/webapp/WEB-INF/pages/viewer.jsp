<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="NextGenPOS">
  <div class="d-flex justify-content-center my-3">
    <h3 id="product_name">All product</h3>

  </div>
  <div class="input-group d-flex justify-content-end mt-2">
      <div class="searchbar mt-3 bg-dark">
        <input class="search_input" type="text" name="" placeholder="Search...">
        <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
      </div>
  </div>
    <div class="row g-2 mt-3 wrapper" id="products">
      <c:forEach var="product" items="${products}">
        <div class="<d-flex align-items-center col " style=" width: 20rem;" >
          <div class="card p-3">
            <div class="d-flex justify-content-between align-items-center ">
              <div class="mt-3">
                <p class="< fs-5 fw-bold">Nume: ${product.productName}</p>
                <div class="mt-1">
                  <h6>Pret: ${product.price} lei</h6>

                </div>
              </div>
              <div class="image">
                <img src="${pageContext.request.contextPath}/ProductPhotos?id=${product.idProduct}" width="80"/>
              </div>
            </div>
            <div>
              <p>Furnizor: ${product.provider}</p>
            </div>
            <a href="${pageContext.request.contextPath}/SingleProduct?idProduct=${product.idProduct}"  class="stretched-link"></a>
          </div>
        </div>
      </c:forEach>
    </div>



</t:pageTemplate>





