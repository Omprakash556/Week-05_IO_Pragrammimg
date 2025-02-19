package com.ioprogramming.anvanced_problem.validateCSVdatabeforeprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidateCSVData {
    // Simple email validation using basic regex pattern
    private static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // Simple phone number validation: Exactly 10 digits
    private static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{10}");
    }

    public static void validateCSV() {
        String filePath = "datafile.csv";  // Change to your actual file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // Flag to skip the header row

            // Header for output
            System.out.println("Valid Records:");
            System.out.println("ID,Name,Department,Email,Phone");

            while ((line = br.readLine()) != null) {
                // Skip the heade

                String[] data = line.split(",");
                if (data.length == 5) {  // Assuming 5 columns: ID, Name, Department, Email, Phone
                    String id = data[0].trim();
                    String name = data[1].trim();
                    String department = data[2].trim();
                    String email = data[3].trim();
                    String phone = data[4].trim();

                    // Validate email and phone number
                    if (isValidEmail(email) && isValidPhoneNumber(phone)) {
                        System.out.println(String.join(",", data));// Valid record, print it
                    } else {
                        System.out.println("Invalid data in row: " + line);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        validateCSV();
    }
}
