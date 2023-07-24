package com.unoveo.pages;

import com.unoveo.dbutils.DButils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class Login extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        System.out.println("in login servlet");
        System.out.println("in doGet");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("encrep");
        System.out.println("username from login jsp "+username );
        String uname =null;
        String pass=null;
        try {
            Connection cn = DButils.getCn();
            System.out.println("in try block");
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);

            MessageDigest m  = MessageDigest.getInstance("MD5");


            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                uname = resultSet.getString(2);
                pass = resultSet.getString(3);
            }

            if(username.equals(uname) && password.equals(pass)){
                System.out.println("if true condition");

                resp.sendRedirect("success");
            }
            else {
                System.out.println("if false condition");
                resp.sendRedirect("error");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        pw.close();
    }

//
//       out.println(" <form action=\"login\" method=\"post\" >");
//        out.println("<label for=\"username\">Username:</label>");
//       out.println("<input type=\"text\" id=\"username\" name=\"username\" required><br>");
//       out.println("<label for=\"password\">Password:</label>");
//        out.println("<input type=\"password\" id=\"password\" name=\"password\" required><br>\n");
//         out.println("<input type=\"submit\" value=\"login\">");
//         out.println("</form>");



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in doPost");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("encrep");
        System.out.println("username from login jsp "+username );
        String uname =null;
        String pass=null;



        try {
            Connection cn = DButils.getCn();
            System.out.println("in try block");
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);


            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                 uname = resultSet.getString(2);
                pass = resultSet.getString(3);
            }


//            if (username.equals(uname) && password.equals(pass)) {
//                System.out.println("if true condition");
//
//                RequestDispatcher dispatcher = req.getRequestDispatcher("success1.jsp");
//                dispatcher.forward(req, resp);
//            } else {
//                System.out.println("if false condition");
//                resp.sendRedirect("error");
//            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pw.close();
    }


}
