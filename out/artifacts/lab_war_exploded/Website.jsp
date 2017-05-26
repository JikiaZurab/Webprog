<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Меню администратора</title>
</head>
<body>
<h1>Пользователи:</h1>
<form action="Website" method="post">
    <input name="Role" type="radio" value="1">1<br>
    <input name="Role" type="radio" value="2">2<br>
    <input name="Role" type="radio" value="3">3<br>
    <input name="Role" type="radio" value="4">4<br>
    <input name="Role" type="radio" value="5">5<br>
    <input name="delete" type="submit" value="delete">
    <input name="Rl"  type="submit" value="user"/>
    <input name="Rl"  type="submit" value="admin"/><br>
</form>
<a href = "http://localhost:8080/MainServlet/SignIn">Sign in</a>
</body>
</html>
