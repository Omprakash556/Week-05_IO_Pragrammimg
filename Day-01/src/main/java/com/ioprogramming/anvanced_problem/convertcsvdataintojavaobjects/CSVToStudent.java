package com.ioprogramming.anvanced_problem.convertcsvdataintojavaobjects;

import java.io.*;
import java.util.*;

public class CSVToStudent {

    public static void main(String[] args) {
        // Path to your CSV file
        String csvFilePath = "students5.csv";

        // List to store Student objects
        List<Student> students = new ArrayList<>();

        // Read the CSV file and convert each row into a Student object
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;

            // Skip the header row (optional)
            br.readLine();

            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                // Split the row by comma
                String[] data = line.split(",");

                // Create a Student object for each row
//
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String department = data[2].trim();
                    String email = data[3].trim();
                    String phoneNumber = data[4].trim();

                    // Add the Student object to the list
                    students.add(new Student(id, name, department, email, phoneNumber));
//
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // Print the Student objects
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
