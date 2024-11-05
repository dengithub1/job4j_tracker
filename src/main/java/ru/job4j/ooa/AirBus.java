package ru.job4j.ooa;

public final class AirBus extends AirCraft {
    private static final int COUNT_ENGINE = 2;
    private final int a380Engines = 4;
    private String name;

    public AirBus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        System.out.println(this.name.equals("A380") ? "Количество двигателей равно: " + a380Engines
                : "Количество двигателей равно: " + COUNT_ENGINE
        );
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
