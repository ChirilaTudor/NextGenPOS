<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="ProductList">
    <div class="row row-cols-3 g-2" id="main">
        <c:forEach var="inventory" items="${inventory}">
            <div class="<d-flex align-items-center col" style="width: 20rem;" >
                <form  class="form-signin" method="POST" action="">
                    <div class="card p-4">
                        <div class="d-flex justify-content-between align-items-center ">
                            <div class="mt-3">
                                <h6>Furnizor: ${inventory.provider}</h6>
                                <div class="mt-1">
                                    <h6 class="main-heading">Nume: ${inventory.productName}</h6>
                                </div>
                            </div>
                            <div class="image">
                                <img src="https://i.imgur.com/MGorDUi.png" width="70">
                            </div>
                        </div>
                        <div class="pt-1">
                            <h6>Stoc: ${inventory.quantity} bucati</h6>
                            <div>
                                <input type="number" id="stock"  class="form-control"  required />
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary text-center mt-3">Modifica Stoc</button>
                                </div>

                            </div>

                        </div>
                    </div>
                </form>
            </div>
        </c:forEach>
    </div>
</t:pageTemplate>