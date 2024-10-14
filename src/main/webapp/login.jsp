<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="userName">Username:</label>
    <input type="text" name="userName" id="userName" required><br><br>
    <button type="submit">Login</button>
</form>
</body>
</html>
