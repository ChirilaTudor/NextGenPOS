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
                    <input type="text" id="category_name" class="form-control form-control-lg cashier-item-box" placeholder="Category name" required/>
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

<%--link poza cashout--%>
<%--https://static.vecteezy.com/system/resources/previews/002/448/571/non_2x/online-grocery-shopping-concept-free-vector.jpg--%>




<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<%--<t:pageTemplate pageTitle="AddCategory">--%>

<%--  <section class="vh-100">--%>
<%--    <div class="container-fluid h-custom">--%>
<%--      <div class="row d-flex justify-content-center align-items-center h-100">--%>

<%--        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">--%>
<%--          <form class="needs-validation" novalidate method="POST"--%>
<%--                action="${pageContext.request.contextPath}/AddCategory">--%>
<%--            <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">--%>
<%--              <p class="lead fw-normal mb-5 fs-1">Category Addition</p>--%>
<%--            </div>--%>

<%--            <div class="form-outline mb-4">--%>
<%--              <label class="form-label" for="category_name">Category name</label>--%>
<%--              <input type="text" id="category_name" class="form-control form-control-lg"/>--%>
<%--              <div class="invalid-feedback">--%>
<%--                Product name is required.--%>
<%--              </div>--%>
<%--            </div>--%>



<%--            <div class="text-center text-lg-start  pt-2">--%>
<%--              <button type="submit" class="btn btn-outline-primary btn-lg"--%>
<%--                      style="padding-left: 2.5rem; padding-right: 2.5rem;">Submit--%>
<%--              </button>--%>
<%--              <p class="small fw-bold mt-2 pt-1 mb-0">--%>
<%--            </div>--%>

<%--          </form>--%>
<%--        </div>--%>

<%--        <div class="col-md-9 col-lg-6 col-xl-5">--%>
<%--          <img src="https://static.vecteezy.com/system/resources/previews/003/339/935/non_2x/set-of-three-online-shopping-step-illustration-free-vector.jpg"--%>
<%--               class="img-fluid " alt="Sample image">--%>
<%--        </div>--%>

<%--      </div>--%>
<%--    </div>--%>
<%--  </section>--%>
<%--</t:pageTemplate>--%>
