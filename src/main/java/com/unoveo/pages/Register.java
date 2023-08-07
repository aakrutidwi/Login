package com.unoveo.pages;

import com.unoveo.dbutils.DButils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter ps = resp.getWriter();


        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println();
        String city = req.getParameter("city");

        try {
            Connection cn = DButils.getCn();
            String insert = "INSERT INTO employee (firstname, lastname, age, city) VALUES ( ?, ?, ?,?)";
            PreparedStatement preparedStatement = cn.prepareStatement(insert);

            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, city);

    int insertedData=preparedStatement.executeUpdate();
            System.out.println("Data enetred successfully");

        resp.sendRedirect("ShowEmployee.jsp");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
