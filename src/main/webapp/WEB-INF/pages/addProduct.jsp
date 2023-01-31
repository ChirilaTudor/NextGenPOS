<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Product">
    <h1>Add Product</h1>
    <form class="needs-validation p-4" novalidate="" method="POST" action="${pageContext.request.contextPath}/AddProduct">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="product_name" class="form-label">Product Name</label>
                <input type="text" class="form-control" id="product_name" name="product_name" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Product name is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="product_quantity" class="form-label">Quantity</label>
                <input type="text" class="form-control" id="product_quantity" name="product_quantity" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Quantity is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="product_price" class="form-label">Price</label>
                <input type="text" class="form-control" id="product_price" name="product_price" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Price is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="product_description" class="form-label">Description</label>
                <input type="text" class="form-control" id="product_description" name="product_description" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Description is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="product_provider" class="form-label">Provider</label>
                <input type="text" class="form-control" id="product_provider" name="product_provider" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Provider is required.
                </div>
            </div>
        </div>

        <button class="btn btn-primary btn-lg" type="submit">Save</button>
    </form>
</t:pageTemplate>
