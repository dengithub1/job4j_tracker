package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        for (int i = 0; i < items.length; i++) {
            if (index == i) {
                items[i].setName(item.getName());
                return true;
            }
        }
        return false;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int sizeOfArray = 0;
        Item[] result = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null) {
                result[sizeOfArray] = name;
                sizeOfArray++;
            }
        }
        result = Arrays.copyOf(result, sizeOfArray);
        return result;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int sizeOfArray = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null && key.equals(item.getName())) {
                rsl[sizeOfArray] = item;
                sizeOfArray++;
            }
        }
        rsl = Arrays.copyOf(rsl, sizeOfArray);
        return rsl;
    }
}