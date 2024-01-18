package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {

    private static final String name = "extra cheese";

    @Override
    public String name() {
        return super.name() + " + " + name;
    }
}
