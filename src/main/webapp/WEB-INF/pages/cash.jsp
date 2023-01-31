<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


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

                  <div class="form-outline form-white mb-4">
                    <label for="payment" class="sr-only"> Money for payment</label>
                    <input type="number" id="payment" class="form-control form-control-lg cashier-item-box" placeholder="Money for payment" required/>
                  </div>

                  <button class="btn btn-outline-primary btn-lg px-5 mt-4 mb-3"  id="complete" onclick="paymentChange()">Complete payment</button>

                <div id="payment_change" class="d-none">
                  <p class="fs-3">Payment change: ${change}</p>
                  <a class="btn btn-outline-primary btn-lg px-5 mt-4 mb-3" href="${pageContext.request.contextPath}/ProductList">Return to page</a>
                </div>

              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>