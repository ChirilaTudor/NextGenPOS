<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Sale">

    <div class="container-lg mx-auto row">
        <h1 class="text-center mb-3 mt-3">Sale</h1>
        <div class="col-10 mt-4">
            <form method="POST" action="${pageContext.request.contextPath}/AddShoppingCartProduct">
                    <div class="input-group form-floating">
                        <input type="text" id="product_id" name="product_id" class="form-control textarea-resizing" placeholder="Product Code" aria-label="With textarea" required autofocus />
                        <label class="inline-block ms-2 fs-4" for="product_id">Product Code</label>
                        <button class="btn btn-outline-primary btn-lg p-auto btn-block" type="submit">Add</button>
                    </div>
            </form>

            <div class="row mt-3 border bg-white rounded">
                <div class="ps-3 mt-3">
                    <div class="row cashier-container-box text-center ps-4">

                        <div class="scrollable">
                            <c:forEach var="product" items="${shoppingCart}">
                                    <div class="row border rounded cashier-item-box bg-white fs-5 mb-2 pt-2">
                                        <div class="row">
                                            <div class="col-1">
                                                    ${product.idProduct}
                                            </div>
                                            <div class="col-5">
                                                <p class="overme">${product.productName}</p>
                                            </div>
                                            <div class="col-3">
                                                <form method="POST" action="${pageContext.request.contextPath}/EditShoppingCartQuantity">
                                                    <div class="row">
                                                        <div class="col-3">
                                                            <input type="submit" name="down" class="btn btn-outline-secondary me-2" value="-">
                                                        </div>
                                                        <div class="col-3">
                                                                ${product.quantity}
                                                        </div>
                                                        <div class="col-3">
                                                            <input type="submit" name="up"  class="btn btn-outline-secondary ms-2" value="+">
                                                        </div>
                                                            <input type="hidden" name="product_id" value="${product.idProduct}" />
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="col-2">
                                                    ${product.price} lei
                                            </div>
                                            <div class="col-1">
                                                <form method="POST" action="${pageContext.request.contextPath}/RemoveShoppingCartProduct">
                                                    <input type="submit" name="up" class="btn btn-outline-danger" value="X">
                                                    <input type="hidden" name="product_id" value="${product.idProduct}" />
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                            </c:forEach>
                        </div>

                    </div>
                </div>
                <div class="end-align mb-2 ps-3 fs-3 my-5 ">
                    <label>Total Price:</label>
                    <c:choose>
                        <c:when test="${totalPrice != null}">
                            ${totalPrice} lei
                        </c:when>
                        <c:otherwise>
                            0 lei
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>



        <div class="col m-auto ms-3">

            <div>
                <a class="btn btn-lg btn-outline-primary btn-block mt-4" href="${pageContext.request.contextPath}/Cash">CASH</a>
            </div>
            <div>
                <a class="btn btn-lg  btn-outline-primary btn-block mt-4" href="${pageContext.request.contextPath}/Card">CARD</a>
            </div>
        </div>
    </div>
</t:pageTemplate>

