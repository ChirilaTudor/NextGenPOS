<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="NextGenPOS">
  <div class="d-flex justify-content-center my-3">

    <c:choose>
      <c:when test="${category.categoryName != null}">
        <h1 id="product_name">${category.categoryName}</h1>
      </c:when>
      <c:otherwise>
        <h1 id="product_name">All products</h1>
      </c:otherwise>
    </c:choose>

  </div>
  <form id="form1" method="GET" action="${pageContext.request.contextPath}/SearchBar">
  <div class="input-group d-flex justify-content-end mt-2">
      <div class="searchbar mt-3 bg-dark">
          <input type="text" id="text_search" name="text_search" class="search_input" placeholder="Search..." />
          <a href="javascript:;" onclick="document.getElementById('form1').submit();" class="search_icon"><i class="fas fa-search"></i></a>
          <input type="hidden" id="viewer" name="viewer" value="search" />
      </div>
  </div>
  </form>
    <div class="row g-2 mt-3 wrapper" id="products">
      <c:forEach var="product" items="${products}">
        <div class="<d-flex align-items-center col overtext " style=" width: 20rem;" >
          <div class="card p-3">
            <div class="d-flex justify-content-between align-items-center ">
              <div class="mt-3">
                <p class="< fs-5 fw-bold overtext">Name: ${product.productName}</p>
                <div class="mt-1">
                  <h6>Price: ${product.price} lei</h6>

                </div>
              </div>
              <div class="image">
                <img src="${pageContext.request.contextPath}/ProductPhotos?id=${product.idProduct}" width="80"/>
              </div>
            </div>
            <div>
              <p>Provider: ${product.provider}</p>
            </div>
            <a href="${pageContext.request.contextPath}/SingleProduct?idProduct=${product.idProduct}"  class="stretched-link"></a>
          </div>
        </div>
      </c:forEach>
    </div>



</t:pageTemplate>





