package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();

        for (String s : origin) {
            check.add(s);
        }

        for (String d : duplicate) {
            if (!check.contains(d)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
