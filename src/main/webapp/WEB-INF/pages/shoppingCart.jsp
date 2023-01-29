<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Shopping Cart">
    <h1>Test Page</h1>
    <form method="POST" action="${pageContext.request.contextPath}/AddShoppingCartProduct">
        <input type="text" id="product_id" name="product_id" class="form-control" placeholder="Product" required autofocus />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add Product</button>
    </form>
    <form method="POST" action="${pageContext.request.contextPath}/ShoppingCart">
        <input type="text" id="user_id" name="user_id" class="form-control" placeholder="User" required autofocus />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Make Sale</button>
    </form>
    <form method="POST" action="${pageContext.request.contextPath}/EditShoppingCartQuantity">
        <input type="text" id="indexProduct" name="indexProduct" class="form-control" placeholder="indexProduct" required autofocus />
        <input type="submit" name="up" value="Up Button">
        <input type="submit" name="down" value="Down Button">
    </form>
</t:pageTemplate>