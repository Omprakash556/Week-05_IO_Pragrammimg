package com.ioprogramming.basic_problem.readandcountcsvdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRows {
    public static void readAndCountRows(){
        String filePath = "student.csv";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null){
                count++;
            }
            System.out.println("Total rows of this students file: "+count);
        }catch (IOException e){
            System.out.println("Exception occur: "+e.getMessage());
        }
    }
    public static void main(String[] args) {
            readAndCountRows();
    }
}
