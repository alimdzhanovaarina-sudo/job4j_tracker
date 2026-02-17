package ru.job4j.action;

import ru.job4j.Tracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Завершение программы ===");
        return false;
    }
}

