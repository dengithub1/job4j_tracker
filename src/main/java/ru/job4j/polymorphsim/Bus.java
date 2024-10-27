package ru.job4j.polymorphsim;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус движется");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В автобусе " + count + " человек");
    }

    @Override
    public int refuel(int fuel) {
        return fuel;
    }
}
