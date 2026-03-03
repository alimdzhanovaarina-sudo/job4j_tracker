package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> result = new LinkedHashSet<>();
        for (String department : departments) {
            String[] parts = department.split("/");
            String currentPath = "";
            for (String part : parts) {
                if (currentPath.isEmpty()) {
                    currentPath = part;
                } else {
                    currentPath += "/" + part;
                }
                result.add(currentPath);
            }
        }
        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);
        return sortedResult;
    }

    public static List<String> sortAsc(List<String> departments) {
        List<String> filled = fillGaps(departments);
        Collections.sort(filled);
        return filled;
    }

    public static List<String> sortDesc(List<String> departments) {
        List<String> filled = fillGaps(departments);
        Collections.sort(filled, Comparator.reverseOrder());
        return filled;
    }
}

