package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("petr@yandex.ru", "Petr Arsentev");
        map.put("abc@yandex.ru", "Petr Arsentev");
        map.put("petr@yandex.ru", "Peter Arsentev");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}