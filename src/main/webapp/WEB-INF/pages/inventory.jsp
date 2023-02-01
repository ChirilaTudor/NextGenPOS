<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Inventory">
    <div class="d-flex justify-content-center my-3">
        <h3 id="product_name">Inventory</h3>
    </div>

    <div class="input-group d-flex justify-content-end mt-2">
        <div class="searchbar bg-dark">
            <input class="search_input" type="text" name="" placeholder="Search...">
            <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
        </div>
    </div>
    <div class="row g-2 mt-3 wrapper" id="products">
        <c:forEach var="inventory" items="${inventory}">
            <div class="<d-flex align-items-center col" style="width: 20rem;" >
                    <div class="card p-4">
                        <div class="d-flex justify-content-between align-items-center ">
                            <div class="mt-3">
                                <h5 class="overtext">Nume: ${inventory.productName}</h5>
                                <div class="mt-1">
                                    <p>Furnizor: ${inventory.provider}</p>
                                    <p>Id: ${inventory.idProduct}</p>
                                </div>
                            </div>
                            <div class="image">
                                <img src="${pageContext.request.contextPath}/ProductPhotos?id=${inventory.idProduct}" width="70"/>
                            </div>
                        </div>
                        <div class="pt-1">
                            <h6>Stoc: ${inventory.quantity} bucati</h6>
                            <div>
                                <form method="POST" class="row" action="${pageContext.request.contextPath}/UpdateStock">
                                    <input type="number" id="product_quantity" name="product_quantity" value="${inventory.quantity}" class="form-control"/>
                                    <input class="btn  text-center text-white bg-dark mt-3 fw-light" type="submit" value="Modify stock"/>
                                    <input type="hidden" id="product_id" name="product_id" value="${inventory.idProduct}" />
                                </form>
                                    <div class="text-center d-flex justify-content-between row">
                                        <a class="btn  text-center text-white bg-dark mt-3 fw-light"
                                            href="${pageContext.request.contextPath}/AddProductPhoto?id=${inventory.idProduct}"
                                            role="button">Add photo</a>
                                    </div>
                            </div>

                        </div>
                    </div>
            </div>
        </c:forEach>
    </div>
</t:pageTemplate>