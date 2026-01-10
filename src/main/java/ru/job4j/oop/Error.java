package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активно: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        defaultError.printInfo();

        Error error404 = new Error(true, 404, "Страница не найдена");
        Error error500 = new Error(false, 500, "Ошибка сервера");
        Error error403 = new Error(true, 403, "Доступ запрещен");

        error404.printInfo();
        error500.printInfo();
        error403.printInfo();
    }
}

