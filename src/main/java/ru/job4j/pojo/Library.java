package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {

        Book book1 = new Book("Book 1", 118);
        Book book2 = new Book("Book 2", 490);
        Book book3 = new Book("Book 3", 99);
        Book book4 = new Book("Clean code", 237);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName() + " " + b.getPages());
        }

        Book temp = books[0];
        books[0] = books[books.length - 1];
        books[books.length - 1] = temp;

        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " " + books[i].getPages());
            }
        }
    }
}
