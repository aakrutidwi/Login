package com.unoveo.pages;



import com.unoveo.dbutils.DButils;
import com.unoveo.secureutils.Encryption;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registeruser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter ps = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Encryption enc = new Encryption();

        try {
            Connection cn = DButils.getCn();
            PreparedStatement preparedStatement =cn.prepareStatement("insert into users (username,password) values (?,?)");
            System.out.println("Instered sucessfully encrypted password");
 String encryptedPswd =enc.encrypt(password);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encryptedPswd);


            int insertedData=preparedStatement.executeUpdate();
            System.out.println("Data enetred successfully");

            resp.sendRedirect("login.jsp");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
