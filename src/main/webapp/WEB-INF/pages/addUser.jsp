<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="Login">

  <div class=" min-vw-100 min-vh-100 container-fluid gradient-custom login-overflow ">
    <div class="container-fluid py-5 h-100 ">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card bg-dark text-white" style="border-radius: 1rem;">
            <div class="card-body p-5 text-center">

              <div class="mb-md-5 mt-md-4 pb-5">
                <h2 class="fw-bold mb-5 ">Add User</h2>

                <form  class="form-signin " method="POST" action="j_security_check">

                  <div class="form-outline form-white mb-4">
                    <label for="firstname" class="sr-only ">First name</label>
                    <input type="text" id="firstname" name="j_firstname" class="form-control" placeholder="First name" required autofocus/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="lastname" class="sr-only ">Last name</label>
                    <input type="text" id="lastname" name="j_lastname" class="form-control" placeholder="Last name" required />
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="cnp" class="sr-only ">CNP</label>
                    <input type="text" id="cnp" name="j_cnp" class="form-control" placeholder="CNP" required />
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="address" class="sr-only ">Address</label>
                    <input type="text" id="address" name="j_address" class="form-control" placeholder="Address" required />
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="date" class="sr-only ">Date</label>
                    <input type="date" id="date" name="j_date" class="form-control" placeholder="Date" required />
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="phone" class="sr-only ">Phone number</label>
                    <input type="date" id="phone" name="j_phone" class="form-control" placeholder="Phone number" required />
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="username" class="sr-only ">Username</label>
                    <input type="text" id="username" name="j_username" class="form-control" placeholder="Username" required />
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="password" class="sr-only ">Password</label>
                    <input type="password" id="password" name="j_password" class="form-control" placeholder="Password" required/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="person" class="sr-only ">Person</label>
                    <input type="datalist" id="person" name="j_person" class="form-control" placeholder="Person" required/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="type-employee" class="sr-only ">Type employee</label>
                    <input type="text" id="type-employee" name="j_person" class="form-control" placeholder="Type employee" required/>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <label for="active" class="sr-only ">Is active</label>
                    <input type="text" id="active" name="j_person" class="form-control" placeholder="Is active" required/>
                  </div>

                </form>

                <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>