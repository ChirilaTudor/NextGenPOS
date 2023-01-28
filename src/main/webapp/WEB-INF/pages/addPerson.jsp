<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:pageTemplate pageTitle="AddPerson">
    <h1>Add Person</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddPerson">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required>
                <div class="invalid-feedback">
                    First name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Last name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cnp">CNP</label>
                <input type="text" class="form-control" id="cnp" name="cnp" placeholder="" value="" required>
                <div class="invalid-feedback">
                    CNP is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Address is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="birthDate">Birth Date</label>
                <input type="date" class="form-control" id="birthDate" name="birthDate" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Birth Date is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="phoneNumber">Phone Number</label>
                <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="" value="" required>
                <div class="invalid-feedback">
                    PhoneNumber is required.
                </div>
            </div>
        </div>
        <hr class="my-4">
        <button class="w-20 btn btn-primary btn-lg" type="submit">Save</button>
    </form>
    <script src="form-validation.js"></script>
</t:pageTemplate>