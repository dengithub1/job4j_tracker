package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza{

    private static final String name = "сыр";

    @Override
    public String name() {
        return super.name() + " + " + name;
    }
}
