package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("/");
        String[] rightParts = right.split("/");
        String leftFirstPart = leftParts[0];
        String rightFirstPart = rightParts[0];

        int firstPartComparisonDesc = rightFirstPart.compareTo(leftFirstPart);
        if (firstPartComparisonDesc == 0) {
            return left.compareTo(right);
        } else {
            return firstPartComparisonDesc;
        }
    }
}

