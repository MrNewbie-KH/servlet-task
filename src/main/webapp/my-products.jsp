<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Products</title>
</head>
<body>
<h2>Products Created by You</h2>

<c:if test="${empty myProducts}">
    <p>You have not created any products yet.</p>
</c:if>

<ul>
    <c:forEach var="product" items="${myProducts}">
        <li>
            Product: ${product.name} - Price: ${product.price}
        </li>
    </c:forEach>
</ul>

<a href="/servlet_assignment/products.jsp">Back to All Products</a>
</body>
</html>
