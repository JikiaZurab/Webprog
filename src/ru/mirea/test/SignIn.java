package ru.mirea.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@WebServlet(name = "SignIn",urlPatterns = {"/MainServlet/SignIn"})
public class SignIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        String role = request.getParameter("Role");
        String loginReg = "";
        String passwordReg = "";
        String roleReg = "";
        List<String> lines = Files.readAllLines(Paths.get("/Users/Admin/Desktop/WebProg/lab/log.txt"), StandardCharsets.UTF_8);
        for (int i = 0; i < (lines.size() - 1) && (!login.equals(loginReg) || !password.equals(passwordReg)); i += 3) {
            loginReg = lines.get(i);
            passwordReg = lines.get(i + 1);
            roleReg = lines.get(i + 2);
        }
        Writer out = response.getWriter();
        if (login.equals(loginReg) && password.equals(passwordReg) && role.equals(roleReg) && role.equals("user")) {//корректный вход как пользователь
            out.write("<html><h1>Sing up as user</h1>" +
                    "<a href = \"http://localhost:8080/MainServlet\">Sign up a new user</a><br>" +
                    "<a href = \"http://localhost:8080/MainServlet/SignIn\">Relogin</a></html>");
        } else if (login.equals(loginReg) && password.equals(passwordReg) && role.equals(roleReg) && role.equals("admin")) {//корректный вход как админ
            out.write("<html><h1>Sing up as administrator</h1>" +
                    "<a href = \"http://localhost:8080/MainServlet/Website\">Admin menu</a></html>");
        } else                                                                                          //некорректный вход
            out.write("<html><h1>Sing in failed. Check login and password!</h1>"+
            "<a href = \"http://localhost:8080/MainServlet/SignIn\">Try again!</a></html>"
            );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/SignIn.jsp").forward(request,response);
    }
}
