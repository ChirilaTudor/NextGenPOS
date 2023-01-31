<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pageTemplate pageTitle="EditProduct">



  <div class=" min-vw-100 min-vh-100 container-fluid login-overflow ">
    <div class="container-fluid py-5 h-100 ">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card bg-gray-100" style="border-radius: 1rem;">
            <div class="card-body p-5 text-center">

              <div class="mb-md-5 mt-md-4 pb-5">
                <h2 class="fw-bold mb-2 text-uppercase">Edit current product</h2>
                <p class="text-white-50 mb-5">reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee</p>

                <form  class="form-signin" method="POST" action="${pageContext.request.contextPath}/EditProduct">
                  <div class="form-outline form-white mb-4">
                    <label for="product_id" class="sr-only">Product ID</label>
                    <input type="text" id="product_id" class="form-control" placeholder="Product ID"/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="product_name" class="sr-only">Product name</label>
                    <input type="text" id="product_name" class="form-control" placeholder="Product name"/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="product_quantity" class="sr-only">Quantity</label>
                    <input type="text" id="product_quantity" class="form-control" placeholder="Quantity"/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="product_price" class="sr-only">Price</label>
                    <input type="text" id="product_price" class="form-control" placeholder="Price"/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="product_description" class="sr-only">Description</label>
                    <input type="text" id="product_description" class="form-control" placeholder="Description"/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="product_provider" class="sr-only">Provider</label>
                    <input type="text" id="product_provider" class="form-control" placeholder="Provider"/>
                  </div>

                  <button class="btn btn-outline-light btn-lg px-5 mt-4" type="submit">Confirm</button>

                </form>


              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>
