<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cashier">

    <div class="container-lg mx-auto row">
    <div class="col-10">
        <div class="row">
        <div class="row">
            <div class="input-group form-floating">
                <textarea class="form-control textarea-resizing" placeholder="The item that you want to add to the list" id="floatingTextarea" aria-label="With textarea"></textarea>
                <label class="inline-block ms-3 fs-4" for="floatingTextarea">Item name</label>
                <a class="btn btn-outline-primary btn-lg p-auto">Add</a>
            </div>
        </div>
        <div class="ps-3 mt-3">
            <div class="row border rounded cashier-container-box ps-4">
                    <%--<c:forEach var="item" items="${items}   //example--%>
                <div class="g-3 scrollable">
                <div class="row border rounded cashier-item-box fs-5 pt-1">
                    <div class="col-6">
                        Product Name
                    </div>
                    <div class="col-1">
                        <i class="fa fa-minus fa-xs"></i>
                    </div>
                    <div class="col-1">
                        Nr
                    </div>
                    <div class="col-1">
                        <i class="fa fa-plus fa-xs"></i>
                    </div>
                    <div class="col-2">
                        Price: 200 lei
                    </div>
                    <div class="col-1">
                        <a class="btn btn-outline-danger">X</a>
                    </div>
                </div>


                        <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                            <div class="col-6">
                                Product Name
                            </div>
                            <div class="col-1">
                                -
                            </div>
                            <div class="col-1">
                                Nr
                            </div>
                            <div class="col-1">
                                +
                            </div>
                            <div class="col-2">
                                Price:
                            </div>
                            <div class="col-1">
                                <a class="btn btn-outline-danger">X</a>
                            </div>
                        </div>


                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>


                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>


                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>


                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>


                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>


                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>

                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>

                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>

                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>

                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>


                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>


                    <div class="row border rounded cashier-item-box mt-2 fs-5 pt-1">
                        <div class="col-6">
                            Product Name
                        </div>
                        <div class="col-1">
                            -
                        </div>
                        <div class="col-1">
                            Nr
                        </div>
                        <div class="col-1">
                            +
                        </div>
                        <div class="col-2">
                            Price:
                        </div>
                        <div class="col-1">
                            <a class="btn btn-outline-danger">X</a>
                        </div>
                    </div>

                </div>
                <div class="end-align">
                    <h3 class="ps-3">
                        Total:
                    </h3>

                </div>
            </div>
        </div>
        </div>
    </div>
    <div class="col h-100%" id="container-button">
        <div class="end-align">
            <div>
                <a class="btn btn-outline-primary btn-lg">CASH</a>
            </div>
            <div>
                <a class="btn btn-outline-primary btn-lg mt-4">CARD</a>
            </div>
        </div>

    </div>
    </div>
</t:pageTemplate>

