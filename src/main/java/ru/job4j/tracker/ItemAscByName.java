package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item nameLeft, Item nameRight) {
        return nameRight.getName().compareTo(nameLeft.getName());
    }
}
