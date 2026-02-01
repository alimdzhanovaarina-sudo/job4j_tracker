package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Arina Alimdzhanova");
        student.setGroup("1");
        student.setDate("2025");

        System.out.println(student.getName() + " in group - " + student.getGroup());
    }
}
