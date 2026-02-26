package ru.job4j.action;

import ru.job4j.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Поиск заявок по имени ===");
        String name = input.askStr("Введите имя: ");
        List<Item> items = tracker.findByName(name);

        /* Исправлено: заменяем .length на .size() */
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем : " + name + " не найдены.");
        }
        return true;
    }
}

