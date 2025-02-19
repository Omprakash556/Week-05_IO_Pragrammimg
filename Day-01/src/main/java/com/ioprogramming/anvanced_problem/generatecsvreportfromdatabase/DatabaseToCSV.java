package com.ioprogramming.anvanced_problem.generatecsvreportfromdatabase;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DatabaseToCSV {

    // Method to fetch employee records from the database and write to CSV
    public static void generateCSVReport(String dbURL, String dbUsername, String dbPassword, String csvFilePath) throws SQLException, IOException {
        // Establish connection to the database
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        // SQL query to fetch employee records
        String sql = "SELECT employee_id, name, department, salary FROM employees";

        // Execute the query and get the result set
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Prepare to write to CSV
        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));

        // Write the CSV header
        writer.write("Employee ID,Name,Department,Salary");
        writer.newLine();

        // Process each row from the ResultSet
        while (rs.next()) {
            int employeeId = rs.getInt("employee_id");
            String name = rs.getString("name");
            String department = rs.getString("department");
            double salary = rs.getDouble("salary");

            // Write each record to CSV
            writer.write(employeeId + "," + name + "," + department + "," + salary);
            writer.newLine();
        }

        // Close resources
        writer.close();
        rs.close();
        stmt.close();
        connection.close();

        System.out.println("CSV report generated successfully at: " + csvFilePath);
    }

    public static void main(String[] args) {
        // Database connection details (change these accordingly)
        String dbURL = "jdbc:mysql://localhost:3306/employees";
        String dbUsername = "root";
        String dbPassword = "Prakash@123";

        // Output CSV file path
        String csvFilePath = "employee_report.csv";

        try {
            // Generate the CSV report from the database
            generateCSVReport(dbURL, dbUsername, dbPassword, csvFilePath);
        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
