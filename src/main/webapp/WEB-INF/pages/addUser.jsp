<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:pageTemplate pageTitle="AddUser">
    <h1>Add User</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddUser">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Username is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="person_id" class="form-label">Person</label>
                <select class="form-select" id="person_id" name="person_id" placeholder="" value="" required>
                    <option value="">Choose...</option>
                    <c:forEach var="person" items="${persons}" varStatus="status">
                        <option value="${person.idPerson}">${person.firstName}${person.lastName}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Person is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="typeEmployee">Type Employee</label>
                <input type="text" class="form-control" id="typeEmployee" name="typeEmployee" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Type Employee is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="isActive">Is Active</label>
                <input type="number" class="form-control" id="isActive" name="isActive" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Is Active is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="user_groups">Groups</label>
                <select class="custom-select d-block w-100" id="user_groups" name="user_groups" multiple>
                    <c:forEach var="user_groups" items="${userGroups}" varStatus="status">
                        <option value="${user_groups}">${user_groups}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <hr class="my-4">
        <button class="w-20 btn btn-primary btn-lg" type="submit">Save</button>
    </form>
    <script src="form-validation.js"></script>
</t:pageTemplate>