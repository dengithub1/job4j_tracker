package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("gena@mail.ru", "Иванов Геннадий Иванович");
        map.put("kolya@mail.ru", "Котов Николай Иванович");
        map.put("kolya@mail.ru", "Котов Николай Николаевич");
        map.put("dima@mail.ru", "Котов Дмитрий Сергеввич");

        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}