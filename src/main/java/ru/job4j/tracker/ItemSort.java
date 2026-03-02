package ru.job4j.tracker;

import ru.job4j.Item;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ItemSort {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(2, "Stas"),
                new Item(1, "Arina"),
                new Item(3, "Petr")
        );

        System.out.println("По возрастанию:");
        Collections.sort(items, new ItemAscByName());
        System.out.println(items);

        System.out.println("По убыванию имени:");
        Collections.sort(items, new ItemDescByName());
        System.out.println(items);
    }
}
