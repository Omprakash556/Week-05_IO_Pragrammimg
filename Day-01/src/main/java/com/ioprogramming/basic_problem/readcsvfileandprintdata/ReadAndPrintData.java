package com.ioprogramming.basic_problem.readcsvfileandprintdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrintData {
    public static void readAndPrintData(){
        String filePath = "student.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                System.out.println("ID "+data[0]+", Name "+data[1]+", Age "+data[2]+", marks "+data[3]);
            }
        }catch (IOException e){
            System.out.println("Error occurs "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        readAndPrintData();
    }
}
