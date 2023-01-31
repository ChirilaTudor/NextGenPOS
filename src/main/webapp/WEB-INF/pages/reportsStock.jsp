<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">

  <div class="container">
    <a class="btn btn-secondary"
       href="${pageContext.request.contextPath}/CreateStockReport" role="button">Create Stock Report</a>
    <a class="btn btn-secondary"
       href="${pageContext.request.contextPath}/CreateSalesReport" role="button">Create Sales Report</a>
    <a class="btn btn-secondary"
       href="${pageContext.request.contextPath}/CreateProductReport" role="button">Create Product Report</a>
    <c:forEach var="reportList" items="${listReportsData}">
      <c:forEach var="report" items="${reportList}">
              <div class="row">
                  <div class="col mb-5">
                      ${report}
                  </div>
                </div>
     </c:forEach>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-1 border-bottom "></div>
    </c:forEach>


</t:pageTemplate>