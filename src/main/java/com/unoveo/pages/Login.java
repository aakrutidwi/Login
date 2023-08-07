package com.unoveo.pages;

import com.unoveo.dbutils.DButils;
import com.unoveo.secureutils.Encryption;
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
        String password = req.getParameter("password");
        System.out.println("taking input from login"+password);

        System.out.println("username from login jsp "+username );
        String uname =null;
        String pass=null;
        Encryption enc = new Encryption();
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

            if(username.equals(uname) && pass.equals(enc.encrypt(password))){
                System.out.println("if true condition");

                resp.sendRedirect("ShowEmployee.jsp");
            }
            else {
                System.out.println("if false condition");
                resp.sendRedirect("AddUser.jsp");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in doPost");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pw.close();
    }


}
