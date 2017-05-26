<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
    <form align="center" action = "MainServlet" method = "POST" onsubmit="validate(this); return false;">
        <h1>Регистрация</h1>
        <p>
            <input name = "Login" type = "text" id="nameInput"/>
            <label>Логин</label>
        </p>
        <p>
            <input name = "Password" type = "text" id="passwordInput"/>
            <label>Пароль</label>
        </p>
        <p><input name="Role" type="hidden" value="user" checked></p>
        <input name = "registration" type = "submit" value="Зарегистрироваться"/><br><br>
        <button><a href = "http://localhost:8080/MainServlet/SignIn">Войти</a></button>
    </form>
</body>
<script>
    alert('<%=request.getAttribute("title")%>');

    function validate(form) {
        var inputName = document.getElementById("nameInput");
        var inputPassword = document.getElementById("passwordInput");
        console.log(event);
        if (inputName.value == '' || inputPassword.value == '') {
            event.stopPropagation(true);
            event.preventDefault();
            alert("Пустое поле");
            return false;
        }

        var regName = /^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$/;
        var regPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$/;

        if (!regName.test(inputName.value) || !regPassword.test(inputPassword.value)){
            event.stopPropagation(true);
            event.preventDefault();
            alert("Некорректный логин или пароль");
            return false;
        } else form.submit();
    }
</script>
</html>
