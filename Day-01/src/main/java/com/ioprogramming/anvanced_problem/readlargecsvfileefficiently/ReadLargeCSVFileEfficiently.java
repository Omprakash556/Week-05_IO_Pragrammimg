package com.ioprogramming.anvanced_problem.readlargecsvfileefficiently;

import java.io.*;

import java.io.*;

public class  ReadLargeCSVFileEfficiently{
    public static void main(String[] args) {
        String filePath = "largedata.csv"; // Large CSV file
        int batchSize = 100;
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                // Process the line (Here, we just count it)
                recordCount++;

                // Print count every batchSize records
                if (recordCount % batchSize == 0) {
                    System.out.println("Records processed: " + recordCount);
                }
            }

            // Print final count
            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
