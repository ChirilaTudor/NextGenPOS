
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Card">
  <div class=" min-vw-100 min-vh-100 container-fluid login-overflow ">
    <div class="container-fluid py-5 h-100 ">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div>
            <div class="text-center">

              <div class="pb-5">
                <p class="lead fw-normal mb-1 fs-1">Card payment</p>
                <p class="lead fw-normal mb-1 fs-1">Please put the card onto the POS</p>

                  <div class="form-outline form-white mb-4 mt-4">
                    <h3>Total:</h3>
                  </div>

                  <div class="popup" id="submit" onclick="myFunction1()">
                    <a class="btn btn-outline-primary btn-lg px-5 mt-4" type="submit" >Submit</a>
                    <span class="popuptext fw-bold d-none" id="myPopup">Transaction complete!</span>
                  </div>

                  <div class="d-none" id="done">
                    <a class="btn text-white bg-dark btn-lg px-5 mt-4" type="submit"  href="${pageContext.request.contextPath}/Sale">Done</a>
                  </div>

              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>