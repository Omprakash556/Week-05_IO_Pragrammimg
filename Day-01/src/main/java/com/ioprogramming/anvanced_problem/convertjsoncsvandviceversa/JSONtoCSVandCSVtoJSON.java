package com.ioprogramming.anvanced_problem.convertjsoncsvandviceversa;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class JSONtoCSVandCSVtoJSON {

    // Convert JSON to CSV
    public static void jsonToCSV(String jsonFilePath, String csvFilePath) throws IOException {
        // Read JSON file
        BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
        StringBuilder jsonContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonContent.append(line);
        }

        // Convert JSON string to JSONArray
        JSONArray jsonArray = new JSONArray(jsonContent.toString());

        // Write to CSV file
        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));

        // Write CSV Header (based on keys in JSON)
        JSONObject firstObject = jsonArray.getJSONObject(0);
        Set<String> keys = firstObject.keySet();
        writer.write(String.join(",", keys));
        writer.newLine();

        // Write each student record
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject student = jsonArray.getJSONObject(i);
            List<String> values = new ArrayList<>();
            for (String key : keys) {
                values.add(student.optString(key)); // Get value or empty string if missing
            }
            writer.write(String.join(",", values));
            writer.newLine();
        }

        writer.close();
    }

    // Convert CSV to JSON
    public static void csvToJSON(String csvFilePath, String jsonFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String headerLine = reader.readLine();  // Read header (first line)

        if (headerLine == null) {
            reader.close();
            return;
        }

        String[] headers = headerLine.split(",");
        List<JSONObject> jsonList = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < headers.length; i++) {
                jsonObject.put(headers[i], values[i]);
            }
            jsonList.add(jsonObject);
        }

        reader.close();

        // Write to JSON file
        JSONArray jsonArray = new JSONArray(jsonList);
        BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFilePath));
        writer.write(jsonArray.toString(4));  // Pretty print with an indentation of 4
        writer.close();
    }

    public static void main(String[] args) {
        try {
            // Example file paths
            String jsonFilePath = "students.json";
            String csvFilePath = "students.csv";
            String outputJsonFilePath = "output_students.json";

            // Convert JSON to CSV
            jsonToCSV(jsonFilePath, csvFilePath);
            System.out.println("JSON to CSV conversion successful!");

            // Convert CSV back to JSON
            csvToJSON(csvFilePath, outputJsonFilePath);
            System.out.println("CSV to JSON conversion successful!");

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}

