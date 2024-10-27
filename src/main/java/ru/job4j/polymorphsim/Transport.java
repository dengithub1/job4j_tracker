package ru.job4j.polymorphsim;

public interface Transport {

    void move();

    void passengers(int count);

    int refuel(int fuel);
}
