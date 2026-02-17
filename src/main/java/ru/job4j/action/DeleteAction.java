package ru.job4j.action;

import ru.job4j.Tracker;
import ru.job4j.actionr.UserAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        if (tracker.delete(id)) {
            out.println("Заявка удалена.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}

