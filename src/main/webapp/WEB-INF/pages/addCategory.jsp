<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pageTemplate pageTitle="AddCategory">



  <div class=" min-vw-100 min-vh-100 container-fluid login-overflow ">
    <div class="container-fluid py-5 h-100 ">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card bg-dark text-white" style="border-radius: 1rem;">
            <div class="card-body p-5 text-center">

              <div class="mb-md-5 mt-md-4 pb-5">
                <h2 class="fw-bold mb-2 text-uppercase">New Category</h2>
                <p class="text-white-50 mb-5">Create a new category of products</p>

                <form  class="form-signin" method="POST" action="${pageContext.request.contextPath}/AddCategory">
                  <div class="form-outline form-white mb-4">
                    <label for="category" class="sr-only">Category name</label>
                    <input type="text" id="category" class="form-control cashier-item-box" placeholder="Category name" required/>
                  </div>

                  <button class="btn btn-outline-light btn-lg px-5 mt-4" type="submit">Create</button>

                </form>


              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>