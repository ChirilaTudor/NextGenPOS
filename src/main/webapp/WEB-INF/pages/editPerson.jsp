<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="Edit User">

  <section class="vh-100">
    <div class="container-fluid h-custom">
      <div class="row d-flex justify-content-center align-items-center h-100">

        <div class="col-md-8 col-lg-6 col-xl-4 ">
          <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditPerson">
            <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
              <p class="lead fw-normal mb-5 fs-1">Edit current user</p>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="first_name">First name</label>
              <input type="text" id="first_name" value="${person.firstName}" name="first_name" class="form-control form-control-lg"/>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="last_name">Last name</label>
              <input type="text" id="last_name" value="${person.lastName}" name="last_name" class="form-control form-control-lg"/>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="address">Address</label>
              <input type="text" id="address" value="${person.address}" name="address" class="form-control form-control-lg"/>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="cnp">CNP</label>
              <input type="text" id="cnp" value="${person.CNP}" name="cnp" class="form-control form-control-lg"/>
              <div class="invalid-feedback">
                Provider is required.
              </div>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="phone_number">Phone Number</label>
              <input type="text" id="phone_number" value="${person.phoneNumber}" name="phone_number" class="form-control form-control-lg"/>
              <div class="invalid-feedback">
                Phone Number is required.
              </div>
            </div>

            <input type="hidden" id="person_id" value="${person.idPerson}" name="person_id" class="form-control form-control-lg"/>


            <div class="text-center text-lg-start mt-4 pt-2">
              <button type="submit" class="btn text-white bg-dark btn-lg"
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
