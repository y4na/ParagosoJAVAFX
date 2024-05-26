package com.example.paragosojavafx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

    public static boolean registerUser(String username, String password, String contactInfo) {
        String sql = "INSERT INTO users (username, password, contact_info) VALUES (?, ?, ?)";
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, contactInfo);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
