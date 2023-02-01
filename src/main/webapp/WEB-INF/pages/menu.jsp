<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="w-auto">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
                <div onclick="openNav()">
                    <a class="navbar-brand margin"><i class="fas fa-stream"></i></a>
                </div>

            <a class="navbar-brand margin" href="${pageContext.request.contextPath}">NextGenPos</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${pageContext.request.getRemoteUser() == null}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Login"><i class="fa fa-star"></i></a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <div id="myNav" class="overlay" >
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

        <!-- Overlay content -->
        <div class="overlay-content">
            <%--<c:choose>
                <c:when test="1">
                    <a href="#" id="viewer1">Drinks</a>
                    <a href="#" id="viewer2">Fruits & Vegetables</a>
                    <a href="#" id="viewer3">Meat</a>
                    <a href="#" id="viewer4">Bakery</a>
                </c:when>

                <c:when test="2">
                    <a href="#" id="general_director1">Inventory</a>// ca product list + suplimentare stoc+add product
                    <a href="#" id="general_director2">Reports</a>
                    <a href="#" id="general_director3">Users</a>
                    <a href="#" id="general_director4">Notifications</a>
                </c:when>

                <c:when test="3">
                    <a href="#" id="cashier1">Product list</a>//+ stock(exact ca viewer), fara descriere
                    <a href="#" id="cashier2">Sale</a>
                    <a href="#" id="cashier3">Return</a>
                </c:when>

                <c:when test="4">
                    <a href="#" id="admin1">Users</a>
                    <a href="#" id="admin2">Security</a>
                </c:when>
            </c:choose>--%>
                <a href="${pageContext.request.contextPath}/Categories" >Select Category</a>
                <a href="${pageContext.request.contextPath}/ProductList" >Product list</a>
                <a href="${pageContext.request.contextPath}/Inventory" id="inventory">Inventory</a>
                <a href="${pageContext.request.contextPath}/Users" id="inventory">Users</a>
                <a href="${pageContext.request.contextPath}/StockReport" id="inventory">Report</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/Sale">Sale</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/Return">Return</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/AddCategory">Add Category</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/AddProduct">Add Product</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/EditableProducts">Edit Product</a>

        </div>
</div>

</header>