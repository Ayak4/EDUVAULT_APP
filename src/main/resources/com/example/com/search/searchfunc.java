package com.example.eduvault_app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchService {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DATABASE_USER = "your_username";
    private static final String DATABASE_PASSWORD = "your_password";

    public List<String> search(String searchTerm) {
        List<String> results = new ArrayList<>();
        String query = "SELECT * FROM your_table_name WHERE column_name LIKE ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + searchTerm + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(resultSet.getString("column_name")); // Modify based on the columns you need
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
}
