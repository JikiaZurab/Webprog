package ru.mirea.test;

import javax.management.relation.Role;
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

@WebServlet(name = "Website", urlPatterns = {"/MainServlet/Website"})
public class Website extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<String> lines = Files.readAllLines(Paths.get("/Users/Admin/Desktop/WebProg/lab/log.txt"), StandardCharsets.UTF_8);
            int role = Integer.parseInt(request.getParameter("Role")) - 1;
            if (request.getParameter("Rl") != null){
                String Rl = request.getParameter("Rl");
                lines.set((role*3+2),Rl);
            }
            else {
                if (lines.size() - 1 > role * 3) {
                    lines.remove(role * 3);
                    lines.remove(role * 3);
                    lines.remove(role * 3);
                }
            }
            PrintWriter printWriter = new PrintWriter("/Users/Admin/Desktop/WebProg/lab/log.txt", "UTF-8");
            for (String line : lines) {
                printWriter.println(line);
            }
            printWriter.close();
            response.getWriter().write("<html><h1>Пользователь был успешно удален</h1>" +
                    "<a href = \"http://localhost:8080/MainServlet/Website\">Вернутся на сайт.</a></html>");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/Website.jsp").forward(request,response);
    }
}
