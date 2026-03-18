package ru.job4j.stream;

import java.util.List;

public class StreamUsage {

    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        public String getName() {
            return name;
        }

        public long getSpent() {
            return spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40),
                new Task("X task", 0)
        );

        tasks.stream()
                .filter(task -> task.getName().contains("Bug"))
                .filter(task -> task.getSpent() > 30)
                .map(task -> task.getName() + " " + task.getSpent())
                .forEach(System.out::println);
    }
}

