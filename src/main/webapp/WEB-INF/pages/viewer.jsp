<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="NextGenPOS">
  <div class="d-flex justify-content-center mt-2">
    <h3 id="product_name">All product</h3>
    <%--<c:set var = "viewer1"  value = "#viewer1"/>
    <c:set var = "viewer2"  value = "#viewer2"/>
    <c:set var = "viewer3"  value = "#viewer3"/>
    <c:set var = "viewer4"  value = "#viewer4"/>

    <c:choose>
      <c:when test="${pageContext.request.getAttribute('#viewer1')}">
        <h3>Drinks</h3>
      </c:when>
      <c:when test="${pageContext.request.getAttribute('#viewer2')}">
        <h3>Fruits & Vegetables</h3>
      </c:when>
      <c:when test="${pageContext.request.getAttribute('#viewer3')}">
        <h3>Meat</h3>
      </c:when>
      <c:when test="${pageContext.request.getAttribute('#viewer4')}">
        <h3>Bakery</h3>
      </c:when>
      <c:otherwise>
        <h3>All products</h3>
      </c:otherwise>
    </c:choose>--%>


  </div>
  <div class="input-group d-flex justify-content-end mt-2">
      <div class="searchbar">
        <input class="search_input" type="text" name="" placeholder="Search...">
        <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
      </div>
  </div>
    <div class="row row-cols-3 g-2 mt-3" id="products">
      <c:forEach var="product" items="${products}">
        <div class="<d-flex align-items-center col " style=" width: 20rem;" >
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
              <h6>Pret: ${product.price} lei</h6>
            </div>
            <a href="${pageContext.request.contextPath}/SingleProduct?idProduct=${product.idProduct}"  class="stretched-link"></a>
          </div>
        </div>
      </c:forEach>
    </div>



</t:pageTemplate>




