package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemSortTest {

    @Test
    void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item(2, "Impl task"),
                new Item(1, "Fix bugs"),
                new Item(3, "Reboot server")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Fix bugs"),
                new Item(2, "Impl task"),
                new Item(3, "Reboot server")
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    void whenDescSort() {
        List<Item> items = Arrays.asList(
                new Item(2, "Impl task"),
                new Item(1, "Fix bugs"),
                new Item(3, "Reboot server")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "Reboot server"),
                new Item(2, "Impl task"),
                new Item(1, "Fix bugs")
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}

