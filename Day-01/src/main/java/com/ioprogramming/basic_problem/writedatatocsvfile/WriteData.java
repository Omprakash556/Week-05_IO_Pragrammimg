package com.ioprogramming.basic_problem.writedatatocsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {
    public static void writeCSV(){
        String filePath = "employee.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ID, Name, Department, Salary \n");
            bw.write("101, Om Prakash, SDE, 28700\n");
            bw.write("102, Deepansh, Testier, 22000\n");
            bw.write("103, Anubhav, Sweeper, 30000\n");
            bw.write("104, Mayank, PM, 29700\n");
            bw.write("105, Manish, Analyst, 28100");
        } catch (IOException e) {
            System.out.println("Exception occur" + e.getMessage());
        }
    }
    public static void main(String[] args) {
       writeCSV();

    }
}
