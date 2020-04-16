package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/welkom", loadOnStartup = 1)
public class Welkom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.println("<h3>Welkom "+username +"</h3>");
//        out.println("<h3>Hello, test!</h3>");
        resp.sendRedirect("welkom.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        User user = new User(name);
        PrintWriter out = resp.getWriter();
        out.println("<h3>Hello " + user.getName() + "</h3>");
    }
}
