<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Login">


    <div class=" min-vw-100 min-vh-100 container-fluid  login-overflow ">
        <div class="container-fluid py-5 h-100 ">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">
                            <div class="mb-md-5 mt-md-4 pb-5">
                                <h2 class="fw-bold mb-2 text-uppercase">Add Photo</h2>
                                <form  class="form-signin" method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AddProductPhoto">
                                    <div class="col-md-6 mb-3 mt-5">
                                        <input type="file" name="file" id="file" required>
                                        <div class="invalid-feedback">
                                            Photo is required.
                                        </div>
                                    </div>
                                    <input type="hidden" name="product_id" value="${product.idProduct}"/>
                                    <hr class="mb-4">
                                    <button class="btn text-white bg-dark btn-lg btn-block" type="submit">Save</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>