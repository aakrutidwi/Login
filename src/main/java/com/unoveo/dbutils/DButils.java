package com.unoveo.dbutils;

import java.sql.*;

public class DButils {
  static Connection cn;

    public static Connection getCn() throws ClassNotFoundException, SQLException {

            Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/validate?user=root&password=root");

        return con;
        }
    }
