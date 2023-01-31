<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">

  <div class="container">
  <div class="row my-5">
    <div class="col col-4 d-flex justify-content-center align-items-center"> <a class="btn bg-dark text-white"
                           href="${pageContext.request.contextPath}/CreateStockReport" role="button">Create Stock Report</a>
    </div>
      <div class="col col-4 d-flex justify-content-center align-items-center">  <a class="btn bg-dark text-white"
                            href="${pageContext.request.contextPath}/CreateSalesReport" role="button">Create Sales Report</a>
      </div>
  <div class="col col-4 d-flex justify-content-center">
      <form action="${pageContext.request.contextPath}/CreateProductReport" method="get">
     <div class="row d-flex justify-content-center align-items-center">
         <div class="col">
             <input type="text" class="form-control" style="width: 100px" id="product-id" name="idProduct" required>
         </div>
         <div class="col ">
             <input type="submit" value="Create Product Report" class="btn bg-dark text-white">
         </div>
     </div>


  </form></div>


  </div>
<c:forEach var="report" items="${reports}" varStatus="loop">
      <div class="accordion " id="accordionFlushExample">
          <div class="accordion-item mb-2 ">
              <h2 class="accordion-header  " id="flush-heading${loop.index.toString()} ">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse${loop.index.toString()}" aria-expanded="false" aria-controls="flush-collapse${loop.index.toString()}">
                      ${loop.index.toString()}: ${report.reportName} from ${report.date.toString()}
                  </button>
              </h2>
              <div id="flush-collapse${loop.index.toString()}" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                  <div class="accordion-body">
                      <c:forEach var="reportData" items="${report.fileContent}">
                          <div class="row">
                              <div class="col mb-5">
                                      ${reportData}
                              </div>
                          </div>
                      </c:forEach>
                  </div>
              </div>
          </div>
      </div>
      </c:forEach>

</t:pageTemplate>