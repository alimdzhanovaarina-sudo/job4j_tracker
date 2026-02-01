package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book remark = new Book("Remark", 211);
        Book lovecraft = new Book("Lovecraft", 1123);
        Book cleanCode = new Book("Clean code", 193);
        Book caesar = new Book("Caesar", 34);

        Book[] books = new Book[4];
        books[0] = remark;
        books[1] = lovecraft;
        books[2] = cleanCode;
        books[3] = caesar;

        System.out.println("--- Initial books ---");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("Название: " + book.getName() + ", Страниц: " + book.getPage());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("Название: " + book.getName() + ", Страниц: " + book.getPage());
        }

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println("Название: " + book.getName() + ", Страниц: " + book.getPage());
            }
        }
    }
}

