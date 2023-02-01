<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="AddUser">
  <section class="h-100 h-custom">
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12">
          <div class="card card-registration card-registration-2" style="border-radius: 15px;">
            <form class="needs-validation" novalidate method="POST"
                  action="${pageContext.request.contextPath}/AddUser">

              <div class="card-body p-0">
                <div class="row g-0">
                  <div class="col-lg-6">

                    <div class="p-5">
                      <h3 class="fw-normal mb-5" style="color: #4835d4;">Person Information</h3>
                      <div class="row">

                          <div class="form-outline">
                            <input type="text" id="firstName"
                                   class="form-control form-control-lg"
                                   name="first_name"/>
                            <label class="form-label" for="firstName">First name</label>
                            <div class="invalid-feedback">
                              First name is required.
                            </div>
                          </div>

                        </div>

                        <div class="col-md-6 mb-4 pb-2">
                          <div class="form-outline">
                            <input type="text" id="lastName"
                                   class="form-control form-control-lg"  name="last_name"/>
                            <label class="form-label" for="lastName">Last name</label>
                            <div class="invalid-feedback">
                              Last name is required.
                            </div>
                          </div>

                      </div>

                      <div class="mb-4 pb-2">

                        <div class="form-outline">
                          <input type="number" id="cnp" class="form-control form-control-lg"  name="cnp"/>
                          <label class="form-label" for="cnp">CNP</label>
                          <div class="invalid-feedback">
                            CNP is required.
                          </div>
                      </div>

                      <div class="form-outline">

                        <input type="text" id="address" class="form-control form-control-lg"  name="address"/>
                        <label class="form-label" for="address">Address</label>
                        <div class="invalid-feedback">
                          Address is required.
                        </div>
                      </div>

                      <div class="col-md-6 mb-4 pb-2">
                        <div class="form-outline">
                          <input type="date" id="birthDate"
                                 class="form-control form-control-lg"  name="birth_date"/>
                          <label class="form-label" for="birthDate">Birth Date</label>
                          <div class="invalid-feedback">
                            Birth Date is required.
                          </div>
                        </div>
                      </div>

                      <div class="row">
                        <div class="col-md-6 mb-4 pb-2 mb-md-0 pb-md-0">

                          <div class="form-outline">
                            <input type="number" id="phoneNumber"
                                   class="form-control form-control-lg"  name="phone_number"/>
                            <label class="form-label" for="phoneNumber">Phone Number</label>
                            <div class="invalid-feedback">
                              Birth Date is required.
                            </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="col-md-6 mb-4 pb-2 mb-md-0 pb-md-0">
                            <div class="form-outline">
                              <input type="number" id="phoneNumber"
                                     class="form-control form-control-lg"/>
                              <label class="form-label" for="phoneNumber">Phone Number</label>
                              <div class="invalid-feedback">
                                Phone Number is required.
                              </div>
                            </div>
                          </div>
                      </div>

                    </div>
                  </div>

                  <div class="col-lg-6 bg-indigo bg-gradient text-white">
                    <div class="p-5">
                      <h3 class="fw-normal mb-5">User Information</h3>
                      <div class="mb-4 pb-2">
                        <div class="form-outline form-white">
                          <input type="text" id="username"
                                 class="form-control form-control-lg"  name="username"/>
                          <label class="form-label" for="username">Username</label>
                          <div class="invalid-feedback">
                            Username is required.
                          </div>
                        </div>
                      </div>

                      <div class="mb-4 pb-2">
                        <div class="form-outline form-white">
                          <input type="password" id="password"
                                 class="form-control form-control-lg"  name="password"/>
                          <label class="form-label" for="password">Password</label>
                          <div class="invalid-feedback">
                            Password is required.
                          </div>
                        </div>
                      </div>

                      <div class="row">
                        <div class="col-md-5 mb-4 pb-2">

                          <div class="form-outline form-white">
                            <input type="text" id="typeEmployee"
                                   class="form-control form-control-lg"  name="user_groups"/>
                            <label class="form-label" for="typeEmployee">Employee
                              Type</label>
                            <div class="invalid-feedback">
                              Employee Type is required.
                            </div>
                          </div>

                        </div>
                      </div>
                      <button type="submit" class="btn btn-light btn-lg"
                              data-mdb-ripple-color="dark">Submit
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
</t:pageTemplate>
