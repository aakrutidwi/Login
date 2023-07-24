package com.unoveo.pages;

import com.unoveo.dbutils.DButils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterSuccess extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection cn = DButils.getCn();
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee");

            while (resultSet.next()){

                String firstname =  resultSet.getString(1);
                String lastname = resultSet.getString(2);
//                int age = Integer.parseInt(resultSet.getString(3));
                String city = resultSet.getString(4);
                System.out.println(" firstname: " + resultSet.getString("lastname"));
                System.out.println(firstname + " " + lastname);
                out.println(firstname+  lastname);


            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





    }

