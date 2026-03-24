package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet().stream()
                .filter(student -> student.account().equals(account))
                .findFirst();
    }

    public Optional<Student> findByName(String name) {
        return students.values().stream()
                .flatMap(Set::stream)
                .filter(student -> student.name().equals(name))
                .findFirst();
    }
}