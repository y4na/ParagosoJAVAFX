package com.example.paragosojavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/paragosojavadb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed!");
        }
    }
}
