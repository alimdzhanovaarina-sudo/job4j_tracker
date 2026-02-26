package ru.job4j.action;

import ru.job4j.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Создание новой заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Создание новой заявление ===");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}

