<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">

               <a class="navbar-brand margin" onclick="openNav()"><i class="fas fa-stream"></i></a>

            <a class="navbar-brand margin" href="${pageContext.request.contextPath}">NextGenPos</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

            </ul>
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
</nav>

    <div id="myNav" class="overlay d-none" >
    <!-- Button to close the overlay navigation -->
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

    <!-- Overlay content -->
    <div class="overlay-content">
        <%--<c:choose>
            <c:when test="1">
                <a href="#" id="viewer1">Drinks</a>
                <a href="#" id="viewer2">Fruits & Vegetables</a>
                <a href="#" id="viewer3">Meat</a>
                <a href="#" id="viewer4">Bakery</a>
                <a href="#" id="viewer5">Home</a>
            </c:when>

            <c:when test="2">
                <a href="#" id="general_director1">Inventory</a>
                <a href="#" id="general_director2">Reports</a>
                <a href="#" id="general_director3">Users</a>
                <a href="#" id="general_director4">Notifications</a>
            </c:when>

            <c:when test="3">
                <a href="#" id="cashier1">Product list</a>
                <a href="#" id="cashier2">Sale</a>
                <a href="#" id="cashier3">Return</a>
            </c:when>

            <c:when test="4">
                <a href="#" id="admin1">Users</a>
                <a href="#" id="admin2">Security</a>
            </c:when>
        </c:choose>--%>
        <a href="#" id="viewer1">Drinks</a>
        <a href="#" id="viewer2">Fruits & Vegetables</a>
        <a href="#" id="viewer3">Meat</a>
        <a href="#" id="viewer4">Bakery</a>
        <a href="#" id="viewer5">Home</a>



    </div>
</div>

</header>