<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pageTemplate pageTitle="EditableProducts">
    <h1 class="bd-title">Products</h1>
    <form method="POST" action="${pageContext.request.contextPath}/EditableProducts">
        <div class="d-flex justify-content-end mx-3">
            <button class="btn btn-danger d-none" type="submit" id="deleteSubmit">Delete Products</button>
        </div>

        <div class="container text-center">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Select</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Price</th>
                    <th scope="col">Provider</th>
                    <th scope="col">Description</th>
                    <th scope="col">Image</th>
                    <th scope="col">Add Image</th>
                    <th scope="col">Edit Product</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="product" items="${products}">

                    <tr>

                        <td><input type="checkbox" name="product_ids" class="checkbox_class" onclick="validate()" value="${product.idProduct}"/></td>
                        <td>${product.productName}</td>
                        <td>${product.quantity}</td>
                        <td>${product.price}</td>
                        <td>${product.provider}</td>
                        <td class="text-break">${product.description}</td>
                        <td><img src="${pageContext.request.contextPath}/ProductPhotos?id=${product.idProduct}"
                                 width="48"/></td>
                        <td><a class="btn btn-secondary"
                               href="${pageContext.request.contextPath}/AddProductPhoto?id=${product.idProduct}"
                               role="button">Add
                            photo</a></td>
                        <td><a class="btn btn-secondary"
                               href="${pageContext.request.contextPath}/EditProduct?id=${product.idProduct}">Edit
                            Product</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
                <%--                <div class="row">--%>
                <%--                            <div class="col">--%>
                <%--                                <input type="checkbox" name="product_ids" value="${product.idProduct}"/>--%>
                <%--                            </div>--%>
                <%--                            <div class="col-sm">--%>
                <%--                                    ${product.productName}--%>
                <%--                            </div>--%>
                <%--                            <div class="col-sm">--%>
                <%--                                    ${product.quantity}--%>
                <%--                            </div>--%>
                <%--                            <div class="col-sm">--%>
                <%--                                    ${product.price}--%>
                <%--                            </div>--%>
                <%--                            <div class="col-sm">--%>
                <%--                                    ${product.provider}--%>
                <%--                            </div>--%>
                <%--                            <div class="col-sm">--%>
                <%--                                    ${product.description}--%>
                <%--                            </div>--%>
                <%--                            <div class="col">--%>
                <%--                                <img src="${pageContext.request.contextPath}/ProductPhotos?id=${product.idProduct}"--%>
                <%--                                     width="48"/>--%>
                <%--                            </div>--%>
                <%--                                &lt;%&ndash;          <c:if test="${pageContext.request.isUserInRole('WRITE_PRODUCTS')}">&ndash;%&gt;--%>
                <%--                            <div class="col">--%>
                <%--                                <a class="btn btn-secondary"--%>
                <%--                                   href="${pageContext.request.contextPath}/AddProductPhoto?id=${product.idProduct}"--%>
                <%--                                   role="button">Add--%>
                <%--                                    photo</a>--%>
                <%--                            </div>--%>
                <%--                            <div class="col">--%>
                <%--                                <a class="btn btn-secondary"--%>
                <%--                                   href="${pageContext.request.contextPath}/EditProduct?id=${product.idProduct}">Edit--%>
                <%--                                    Product</a>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                        &lt;%&ndash;          </c:if>&ndash;%&gt;--%>
                <%--                </div>--%>
        </div>
    </form>
</t:pageTemplate>
