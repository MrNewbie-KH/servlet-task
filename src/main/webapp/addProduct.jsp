<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h2>Add a New Product</h2>
<form action="${pageContext.request.contextPath}/catalog/products" method="post">
    <label for="productName">Product Name:</label>
    <input type="text" name="productName" id="productName" required><br><br>

    <label for="productPrice">Product Price:</label>
    <input type="number" step="0.01" name="productPrice" id="productPrice" required><br><br>

    <button type="submit">Add Product</button>
</form>

<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<a href="/servlet_assignment/products.jsp">Back to Product List</a>
</body>
</html>
