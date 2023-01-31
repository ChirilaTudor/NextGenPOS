<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Inventory">
    <div class="input-group d-flex justify-content-end mt-2">
        <div class="searchbar">
            <input class="search_input" type="text" name="" placeholder="Search...">
            <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
        </div>
    </div>
    <div class="row row-cols-3 g-2 mt-3" id="products">
        <c:forEach var="inventory" items="${inventory}">
            <div class="<d-flex align-items-center col" style="width: 20rem;" >
                <form  class="form-signin" method="POST" action="">
                    <div class="card p-4">
                        <div class="d-flex justify-content-between align-items-center ">
                            <div class="mt-3">
                                <h5>Nume: ${inventory.productName}</h5>
                                <div class="mt-1">
                                    <p>Furnizor: ${inventory.provider}</p>
                                </div>
                            </div>
                            <div class="image">
                                <img src="https://i.imgur.com/MGorDUi.png" width="70">
                            </div>
                        </div>
                        <div class="pt-1">
                            <h6>Stoc: ${inventory.quantity} bucati</h6>
                            <div>
                                <input type="number" id="stock"  class="form-control"/>
                                <div class="text-center d-flex justify-content-between">
                                    <a type="submit" class="btn btn-primary text-center mt-3 fw-light">Modifica Stoc</a>
                                    <a  class="btn btn-primary text-center mt-3 fw-light" href="${pageContext.request.contextPath}/AddProductPhoto">Adauga Imagine</a>
                                </div>

                            </div>

                        </div>
                    </div>
                </form>
            </div>
        </c:forEach>
    </div>
</t:pageTemplate>