<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Login">

    <c:if test="${message != null}">
        <div class="alert alert-warning" role="alert">
                ${message}
        </div>
    </c:if>

<%--    <form class="form-signin" method="POST" action="j_security_check">
        <h1 class="h3 mb-3 font-weight-normal p-2">Sign in</h1>

        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" name="j_username" class="form-control" placeholder="Username" required autofocus/>

        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="j_password" class="form-control" placeholder="Password" required/>

        <button class="btn btn-lg btn-primary btn-block m-2" type="submit">Sign in</button>

    </form>--%>
    <section class="vh-50 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">
                                <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                                <p class="text-white-50 mb-5">Please enter your username and password!</p>

                                <form  class="form-signin " method="POST" action="j_security_check">
                                    <div class="form-outline form-white mb-4">
                                        <label for="username" class="sr-only ">Username</label>
                                        <input type="text" id="username" name="j_username" class="form-control" placeholder="Username" required autofocus/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label for="password" class="sr-only ">Password</label>
                                        <input type="password" id="password" name="j_password" class="form-control" placeholder="Password" required/>
                                    </div>

                                </form>

                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>



</t:pageTemplate>