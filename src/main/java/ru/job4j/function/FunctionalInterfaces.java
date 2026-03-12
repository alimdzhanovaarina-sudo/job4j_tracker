package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (key, value) -> map.put(key, value);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");

        BiPredicate<Integer, String> biPredicate = (key, value) -> key % 2 == 0 || value.length() == 4;
        for (Integer key : map.keySet()) {
            if (key % 2 == 0 || map.get(key).length() == 4) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }
        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = new ArrayList<>(map.values());

        Consumer<String> consumer = s -> System.out.println(s);
        Function<String, String> function = s -> s.toUpperCase();
        for (String string : strings) {
            System.out.println(string.toUpperCase());
        }
    }
}