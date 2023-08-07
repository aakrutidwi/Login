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

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection cn = null;
        PreparedStatement preparedStatement = null;
        try {
            cn = DButils.getCn();
            String query = "DELETE FROM employee WHERE id=?";
            preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No employee found with ID " + id + ".");
            }
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }
    public void update(int id) throws SQLException, ClassNotFoundException {
        Connection cn = null;
        PreparedStatement preparedStatement = null;
        try {
            cn = DButils.getCn();
            String query = "update employee set value";
            preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + id + " updated successfully.");
            } else {
                System.out.println("No employee found with ID " + id + ".");
            }
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection cn = DButils.getCn();
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

            while (resultSet.next()) {
                String firstname = resultSet.getString(1);
                String lastname = resultSet.getString(2);
                String city = resultSet.getString(4);
                System.out.println(" firstname: " + resultSet.getString("lastname"));
                System.out.println(firstname + " " + lastname);
                out.println(firstname + " " + lastname);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
