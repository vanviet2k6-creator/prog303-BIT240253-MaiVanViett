package com.mycompany.javatest22;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class JavaTest22 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Nhap sinh vien thu " + i);

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Ten: ");
            String name = sc.nextLine();

            System.out.print("GPA: ");
            double gpa = sc.nextDouble();

            list.add(new Student(id, name, gpa));
        }

        System.out.println("Dang tinh GPA...");

        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Loi khi sleep");
            }
            return calculateAverageGpa(list);
        });

        cf.thenAccept(result -> {
            System.out.println("GPA trung binh: " + result);
        });

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        sc.close();
    }

    public static double calculateAverageGpa(List<Student> list) {

        double sum = 0;

        for (Student s : list) {
            sum += s.getGpa();
        }

        return sum / list.size();
    }
}