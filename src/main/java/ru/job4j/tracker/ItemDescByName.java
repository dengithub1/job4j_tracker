package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item nameLeft, Item nameRight) {
        return nameLeft.getName().compareTo(nameRight.getName());
    }
}
