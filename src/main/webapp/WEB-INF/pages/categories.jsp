
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Categories">
  <div class="d-flex justify-content-center my-3">
    <h1 id="product_name ">Categories</h1>
  </div>

  <div class="d-flex justify-content-center">
    <table class="table center w-10">
      <thead>
      <tr>
        <th scope="col"></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="category" items="${categories}">
        <tr>
          <td class="text-center"><a class=" btn btn-link text-dark fs-2" style="text-decoration: none">${category.categoryName}</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>


</t:pageTemplate>
