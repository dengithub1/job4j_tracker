package ru.job4j.oop;

public class Error {

    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Состояние: " + active);
        System.out.println("Номер статуса : " + status);
        System.out.println("Сообщение : " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true,200,"OK");
        Error error3 = new Error(false,500,"ERROR");

        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
