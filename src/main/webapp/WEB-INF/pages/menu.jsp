<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="w-auto">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <div class="container-fluid">
                <div onclick="openNav()">
                    <a class="navbar-brand margin"><i class="fas fa-stream"></i></a>
                </div>

            <a class="navbar-brand margin" href="${pageContext.request.contextPath}">NextGenPos</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent" >

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

        <div class="overlay-content">

                <a href="${pageContext.request.contextPath}/Categories">Select Category</a>
                <a href="${pageContext.request.contextPath}/ProductList">Product list</a>
                <a href="${pageContext.request.contextPath}/Inventory">Inventory</a>
                <a href="${pageContext.request.contextPath}/Users">Users</a>
                <a href="${pageContext.request.contextPath}/Notification">Notification</a>
                <a href="${pageContext.request.contextPath}/StockReport">Report</a>
                <a href="${pageContext.request.contextPath}/AddUser">Add User</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/ShoppingCart">Sale</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/Return">Return</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/AddCategory">Add Category</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/AddProduct">Add Product</a>
                <a class="nav-link " href="${pageContext.request.contextPath}/EditableProducts">Edit Product</a>

        </div>
</div>

</header>