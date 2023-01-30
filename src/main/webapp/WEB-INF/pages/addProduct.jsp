<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="AddProduct">

  <section class="vh-100">
    <div class="container-fluid h-custom">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-md-9 col-lg-6 col-xl-5">
          <img src="https://static.vecteezy.com/system/resources/previews/007/267/477/non_2x/shopping-cart-and-laptop-computer-with-products-isolated-on-white-background-shop-online-concept-free-vector.jpg"
               class="img-fluid" alt="Sample image">
        </div>
        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
          <form class="needs-validation" novalidate method="POST"
                action="${pageContext.request.contextPath}/AddProduct">
            <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
              <h3 class="lead fw-normal mb-5">Product Addition</h3>
            </div>

            <div class="form-outline mb-4">
              <input type="text" id="product_name" class="form-control form-control-lg"/>
              <label class="form-label" for="product_name">Product name</label>
              <div class="invalid-feedback">
                Product name is required.
              </div>
            </div>

            <div class="form-outline mb-4">
              <input type="number" id="product_quantity" class="form-control form-control-lg"/>
              <label class="form-label" for="product_quantity">Quantity</label>
              <div class="invalid-feedback">
                Quantity is required.
              </div>
            </div>

            <div class="form-outline mb-4">
              <input type="number" id="product_price" class="form-control form-control-lg"/>
              <label class="form-label" for="product_price">Price</label>
              <div class="invalid-feedback">
                Price is required.
              </div>
            </div>

            <div class="form-outline mb-4">
              <input type="text" id="product_provider" class="form-control form-control-lg"/>
              <label class="form-label" for="product_provider">Provider</label>
              <div class="invalid-feedback">
                Provider is required.
              </div>
            </div>

            <div class="form-outline form-white mb-4">
                            <textarea class="form-control" id="product_description"
                                      rows="3" required></textarea>
              <label for="product_description" class="d-flex p-2">Product description</label>
              <div class="invalid-feedback">
                Product description is required.
              </div>
            </div>

            <div class="text-center text-lg-start mt-4 pt-2">
              <button type="submit" class="btn btn-primary btn-lg"
                      style="padding-left: 2.5rem; padding-right: 2.5rem;">Submit
              </button>
              <p class="small fw-bold mt-2 pt-1 mb-0">
            </div>

          </form>
        </div>
      </div>
    </div>
  </section>
</t:pageTemplate>