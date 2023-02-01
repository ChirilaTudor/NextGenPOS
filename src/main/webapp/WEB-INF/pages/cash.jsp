<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cash">



  <div class=" min-vw-100 min-vh-100 container-fluid login-overflow ">
    <div class="container-fluid py-5 h-100 ">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div>
            <div class="text-center">

              <div class="pb-5">
                <p class="lead fw-normal mb-1 fs-1">Cash payment</p>
                <p class="mb-5">Please insert the amount of money for payment</p>

                <p class="fs-3">Total price: ${total} lei</p>


                <c:choose>
                  <c:when test="${change != null}">
                    <h3>Payment change: ${change} lei</h3>
                    <form method="POST" action="${pageContext.request.contextPath}/Sale">
                        <button class="btn btn-outline-primary btn-lg px-5 mt-4 mb-3">Make Sale</button>
                    </form>
                  </c:when>
                  <c:otherwise>
                  <form method="GET" action="${pageContext.request.contextPath}/Cash">
                    <div class="form-outline form-white mb-4">
                      <label for="money_given" class="sr-only">Money for payment</label>
                      <input type="number" id="money_given" name="money_given" class="form-control form-control-lg cashier-item-box" placeholder="Money for payment" required/>
                      <input type="hidden" id="total" name="total" value="${total}"/>
                    </div>

                    <button class="btn btn-outline-primary btn-lg px-5 mt-4 mb-3"  id="complete">Complete payment</button>
                  </form>
                  </c:otherwise>
                </c:choose>

              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>