<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pageTemplate pageTitle="AddCategory">

  <div class=" min-vw-100 min-vh-100 container-fluid login-overflow ">
    <div class="container-fluid py-5 ">
      <div class="row d-flex justify-content-center align-items-center">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div>
            <div class="text-center">

              <div class="pb-5">
                <p class="lead fw-normal mb-1 fs-1">Category Addition</p>
                <p class="mb-5">Create a new category of products</p>

                <form  class="form-signin" method="POST" action="${pageContext.request.contextPath}/AddCategory">
                  <div class="form-outline form-white mb-4">
                    <label for="category_name" class="sr-only">Category name</label>
                    <input type="text" id="category_name" name="category_name" class="form-control form-control-lg cashier-item-box" placeholder="Category name" required/>
                  </div>

                  <button class="btn btn-outline-primary btn-lg px-5 mt-4" type="submit">Submit</button>
                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>
