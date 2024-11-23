<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Trang đăng nhập</title>
</head>
<body>
<form:form action="login" method="post" modelAttribute="model">
    <p>${model}</p>
    <p>
        <label>Username</label>
        <input type="text" name="userName">
    </p>
    <p>
        <label>Passwords</label>
        <input type="text" name="password">
    </p>
    <button type="submit">login</button>
</form:form>
</body>
</html>