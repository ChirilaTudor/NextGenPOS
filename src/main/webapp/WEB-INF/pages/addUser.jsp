<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Product">
    <h1>Add User</h1>
    <form class="needs-validation p-4" novalidate="" method="POST" action="${pageContext.request.contextPath}/AddUser">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Username is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cnp" class="form-label">Cnp</label>
                <input type="text" class="form-control" id="cnp" name="cnp" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Cnp is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="birth_date" class="form-label">Birth Date</label>
                <input type="date" class="form-control" id="birth_date" name="birth_date" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Birth Date is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Address is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="first_name" class="form-label">First Name</label>
                <input type="text" class="form-control" id="first_name" name="first_name" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    First Name is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="last_name" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="last_name" name="last_name" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Last Name is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="phone_number" class="form-label">Phone number</label>
                <input type="text" class="form-control" id="phone_number" name="phone_number" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Phone Number is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="user_groups">Type</label>
                <select class="custom-select d-block w-100" id="user_groups" name="user_groups" multiple>
                    <c:forEach var="user_group" items="${userGroups}" varStatus="status">
                        <option value="${user_group}">${user_group}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <button class="btn btn-primary btn-lg" type="submit">Save</button>
    </form>
</t:pageTemplate>
