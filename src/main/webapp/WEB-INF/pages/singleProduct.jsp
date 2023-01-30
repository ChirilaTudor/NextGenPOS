<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Product">

  <div class=" min-vw-100 min-vh-100 container-fluid  login-overflow ">
    <div class="container-fluid py-5 h-100 ">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card bg-dark bg-gradient text-white" style="border-radius: 1rem;">
            <div class="card-body p-4 text-center">
              <div class="mb-md-5 mt-md-2 pb-5">
                <h2 class="main-heading mt-0">${single_product.productName}</h2>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="mt-4">
                    <h4>Furnizor: ${single_product.provider}</h4>
                    <div class="text-break">
                      <h4>Descriere: ${single_product.description}</h4>
                    </div>
                    <div class="mt-1">
                      <h5>Pret: ${single_product.price} lei</h5>
                    </div>
                  </div>
                  <div class="image">
                    <img src="https://i.imgur.com/MGorDUi.png" width="150">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</t:pageTemplate>




