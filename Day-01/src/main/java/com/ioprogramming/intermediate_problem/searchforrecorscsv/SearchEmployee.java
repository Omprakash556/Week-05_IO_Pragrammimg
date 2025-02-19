package com.ioprogramming.intermediate_problem.searchforrecorscsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchEmployee {

    public static void searchEmployee(String input){
        String filepath = "employee.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                String name = data[1];
                String dept = data[2];
                int slry = Integer.parseInt(data[3]);
                try {
                    if(name.equals(input)){
                        System.out.println("Department: "+dept);
                        System.out.println("Salary: "+slry);
                    }
                }catch (NumberFormatException e){
                    System.out.println("Name is not present in employee list: ");
                }

             }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        searchEmployee("Prakash");

    }
}
