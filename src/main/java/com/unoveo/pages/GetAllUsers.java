package com.unoveo.pages;

import com.unoveo.dbutils.DButils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GetAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw=resp.getWriter();

        try {
            Connection cn = DButils.getCn();
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()){

                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                System.out.println(" username: " + resultSet.getString("username"));
                System.out.println(username + " " + password);
                pw.println(username +  password);

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//
        pw.close();

    }
}
