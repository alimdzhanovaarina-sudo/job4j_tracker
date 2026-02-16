package ru.job4j.tracker;

import ru.job4j.Item;
import ru.job4j.Tracker;

public class CreateAction implements UserAction {
    private final Output out; // 1. Добавляем поле

    public CreateAction(Output out) { // 2. Добавляем конструктор
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create a new Item ==="); // 3. Заменяем System.out на out
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}

