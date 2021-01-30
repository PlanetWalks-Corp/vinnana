<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<body>
<h1>Login</h1>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<a href="/oauth2/authorization/google">Login With Google</a>
<form action="login" method="POST">
    <input type="text" name="username" value="">
    <input type="password" name="password">
    <input type="submit" name="submit" value="submit">
</form>
</body>
</html>
