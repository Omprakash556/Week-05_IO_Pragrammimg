package com.ioprogramming.anvanced_problem.convertcsvdataintojavaobjects;

public class Student {
    private int id;
    private String name;
    private String department;
    private String email;
    private String phoneNumber;

    public Student(int id, String name, String department, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Department=" + department + ", Email=" + email + ", Phone=" + phoneNumber + "]";
    }

    // Getters and Setters can be added as necessary
}

