<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="EditProduct">

  <section class="vh-100">
    <div class="container-fluid h-custom">
      <div class="row d-flex justify-content-center align-items-center h-100">

        <div class="col-md-8 col-lg-6 col-xl-4 ">
          <form class="needs-validation" novalidate method="POST"
                action="${pageContext.request.contextPath}/EditProduct">
            <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
              <p class="lead fw-normal mb-5 fs-1">Edit current product</p>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="product_id">Product ID</label>
              <input type="text" id="product_id" value="${product.idProduct}" class="form-control form-control-lg"/>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="product_name">Product name</label>
              <input type="text" id="product_name" value="${product.productName}" class="form-control form-control-lg"/>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="product_quantity">Quantity</label>
              <input type="number" id="product_quantity" value="${product.quantity}" class="form-control form-control-lg"/>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="product_price">Price</label>
              <input type="number" id="product_price" value="${product.price}" class="form-control form-control-lg"/>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="product_provider">Provider</label>
              <input type="text" id="product_provider" value="${product.provider}" class="form-control form-control-lg"/>
              <div class="invalid-feedback">
                Provider is required.
              </div>
            </div>

            <div class="form-outline form-white mb-4">
              <label for="product_description" class="d-flex p-2">Product description</label>
              <textarea class="form-control" id="product_description" value="${product.description}" rows="3" required></textarea>
            </div>

            <div class="text-center text-lg-start mt-4 pt-2">
              <button type="submit" class="btn btn-outline-primary btn-lg"
                      style="padding-left: 2.5rem; padding-right: 2.5rem;">Submit
              </button>
              <p class="small fw-bold mt-2 pt-1 mb-0">
            </div>

          </form>
        </div>

        <div class="col-md-9 col-lg-6 col-xl-5" >
          <img src="https://i.postimg.cc/GpyPTZ2n/product-taxonomy-1-removebg-preview.png"
               class="img-fluid" alt="General Kenobi">
        </div>

      </div>
    </div>
  </section>
</t:pageTemplate>
