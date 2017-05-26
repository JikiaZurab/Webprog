<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h1 align="center">Добро пожаловать</h1>
<form align="center" action="SignIn" method = "POST">
    <p>
        <input type="text" id = "Login" name ="Login"><label for="Login">Логин</label>
    </p>
    <p>
        <input type="text" id = "Password" name ="Password"><label for="Password">Пароль</label>
    </p>
    <p><input name="Role" type="radio" value="user" checked>User</p>
    <p><input name="Role" type="radio" value="admin">Admin</p>
    <input type = "submit" value="Вход"/>
    <button><a href = "http://localhost:8080/MainServlet">Регистрация</a></button>
</form>
</body>
