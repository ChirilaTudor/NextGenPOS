<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Sale">

    <div class="container-lg mx-auto row">
    <div class="col-10 mt-4">
        <div class="row">
        <div class="row">
            <div class="input-group form-floating">
                <textarea class="form-control textarea-resizing bg-dark text-white" placeholder="The item that you want to add to the list" id="floatingTextarea" aria-label="With textarea"></textarea>
                <label class="inline-block ms-3 fs-4 text-white" for="floatingTextarea">Item name</label>
                <a class="btn btn-outline-primary btn-lg p-auto bg-dark">Add</a>
            </div>
        </div>
        <div class="ps-3 mt-3">
            <div class="row border rounded cashier-container-box bg-dark text-white ps-4">

                <div class="g-3 scrollable">
                <div class="row border rounded cashier-item-box fs-5 pt-2">
                    <div class="col-6">
                        ${name}
                    </div>
                    <div class="col-1">
                        <i class="fa fa-minus fa-xs btn btn-outline-secondary"></i>
                    </div>
                    <div class="col-1 ps-4">
                        ${nr}
                    </div>
                    <div class="col-1">
                        <i class="fa fa-plus fa-xs btn btn-outline-secondary"></i>
                    </div>
                    <div class="col-2">
                        Price: ${price} lei
                    </div>
                    <div class="col-1">
                        <a class="btn btn-outline-danger">X</a>
                    </div>
                </div>
                </div>

            </div>
            <div class="end-align mb-3">
                <h3 class="ps-3">
                    Total:
                </h3>
            </div>
        </div>
        </div>
    </div>

    <div class="col h-100%" id="container-button">
        <div class="end-align">
            <div>
                <a class="btn btn-outline-primary btn-lg bg-dark">CASH</a>
            </div>
            <div>
                <a class="btn btn-outline-primary btn-lg mt-4 bg-dark">CARD</a>
            </div>
        </div>

    </div>
    </div>
</t:pageTemplate>

