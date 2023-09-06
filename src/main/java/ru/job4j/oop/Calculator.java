package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public double sumAllOperations(int y) {
        return sum(y) + minus(y) + divide(y) + minus(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        Calculator.minus(10);
        Calculator calculator = new Calculator();
        calculator.multiply(4);
        calculator.sumAllOperations(7);

    }
}
