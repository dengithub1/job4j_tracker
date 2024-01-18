package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese{

    private static final String name = "томаты";

    @Override
    public String name() {
        return super.name() + " + " + name;
    }
}
