package com.ioprogramming.intermediate_problem.filterrecordsfromcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterStudents {
    public static void readAndFilterStudent(){
        String filePath = "student.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null){
              String[] data = line.split(",");
                try {
                    String name = data[1];
                    int marks = Integer.parseInt(data[3]);
                    if (marks > 80) {
                        System.out.println("Name: " + name + ", Marks is: " + marks + " ");
                    }

              }catch (NumberFormatException i){
                  i.printStackTrace();
              }


            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
readAndFilterStudent();
    }
}
