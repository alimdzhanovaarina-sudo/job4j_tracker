package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("\\.", 2);
        int leftNum = Integer.parseInt(leftParts[0]);
        String[] rightParts = right.split("\\.", 2);
        int rightNum = Integer.parseInt(rightParts[0]);
        return Integer.compare(leftNum, rightNum);
    }
}

