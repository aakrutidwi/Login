package com.unoveo.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hello")
public class Myservlet extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Namaste Duniya";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        System.out.println("do get method works");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
}
