package com.mycompany.javatest22;

public class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}