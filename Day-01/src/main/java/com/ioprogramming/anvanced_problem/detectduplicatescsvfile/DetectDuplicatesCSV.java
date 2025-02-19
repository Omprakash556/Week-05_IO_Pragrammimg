package com.ioprogramming.anvanced_problem.detectduplicatescsvfile;

import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "employeeduplicate.csv"; // Change to actual file path
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 2) continue; // Ensure the line has enough columns

                String id = data[0].trim(); // Assuming the first column is "ID"

                if (!uniqueIds.add(id)) {
                    duplicateRecords.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print duplicate records
        if (!duplicateRecords.isEmpty()) {
            System.out.println("Duplicate Records Found:");
            duplicateRecords.forEach(System.out::println);
        } else {
            System.out.println("No duplicate records found.");
        }
    }
}

