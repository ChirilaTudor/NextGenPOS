<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="w-auto">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
                <div onclick="openNav()">
                    <a class="navbar-brand margin"><i class="fas fa-stream"></i></a>
                </div>

            <a class="navbar-brand margin" href="${pageContext.request.contextPath}">NextGenPos</a>
        <a class="navbar-brand margin nav-link ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/cashier.jsp' ? ' active' : ''}"
           aria-current="page" href="${pageContext.request.contextPath}/Cashier">Cashier</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            </ul>

        </div>
    </div>
</nav>

    <div id="myNav" class="overlay" >
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

        <!-- Overlay content -->
        <div class="overlay-content">

            <%--<c:choose>
            title change on category??????
            search bar unde exista produse(terminat)
            viewer card clickable -> + descriere ????(terminat aproape)
                <c:when test="1">
                    <a href="#" id="viewer1">Drinks</a>
                    <a href="#" id="viewer2">Fruits & Vegetables</a>
                    <a href="#" id="viewer3">Meat</a>
                    <a href="#" id="viewer4">Bakery</a>
                </c:when>

                <c:when test="2">
                    <a href="${pageContext.request.contextPath}/Inventory" id="inventory">Inventory</a>
                    <a href="#" id="general_director1">Inventory</a>// + add image buton
                    <a href="#" id="general_director2">Reports</a>
                    <a href="#" id="general_director3">Users</a>
                    <a href="#" id="general_director4">Notifications</a>
                     <a class="nav-link " href="${pageContext.request.contextPath}/AddProduct" id="general_director5">Add Product</a>
                </c:when>

                <c:when test="3">
                    <a href="${pageContext.request.contextPath}/ProductList" id="cashier1">Product list</a>
                    <a href="#" id="cashier2">Sale</a>
                    <a href="#" id="cashier3">Return</a>
                </c:when>

                <c:when test="4">
                    <a href="#" id="admin1">Users</a>
                    <a href="#" id="admin2">Security</a> de cautat pagina de security(optional)
                </c:when>
            </c:choose>--%>
            <a href="${pageContext.request.contextPath}/Products" id="viewer1" onclick="changeName()">Drinks</a>
            <a href="${pageContext.request.contextPath}/Products" id="viewer2" onclick="changeName()">Fruits & Vegetables</a>
            <a href="${pageContext.request.contextPath}/Products" id="viewer3" onclick="changeName()">Meat</a>
            <a href="${pageContext.request.contextPath}/Products" id="viewer4" onclick="changeName()">Bakery</a>
                <a href="${pageContext.request.contextPath}/ProductList" id="cashier1">Product list</a>
                <a href="${pageContext.request.contextPath}/Inventory" id="inventory">Inventory</a>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${pageContext.request.getRemoteUser() == null}">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
        </div>
</div>

</header>