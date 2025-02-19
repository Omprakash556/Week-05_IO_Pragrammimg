package com.ioprogramming.intermediate_problem.sortcsvrecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Employee {
    int id;
    String name;
    String role;
    int salary;

    public Employee(int id, String name, String role, int salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + role + "," + salary;
    }
}

public class SortSalary {
    public static void sortAndPrintTop5() {
        String filePath = "employee.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String role = data[2].trim();
                    int salary = Integer.parseInt(data[3].trim());
                    employees.add(new Employee(id, name, role, salary));
                }
            }

            employees.sort((e1, e2) -> Integer.compare(e2.salary, e1.salary));

            System.out.println("Top 5 Highest Paid Employees:");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(employees.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        sortAndPrintTop5();
    }
}
