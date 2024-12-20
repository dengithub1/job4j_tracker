package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(20, -14, -3, 1, 8, 29, -4, 76, 0, 3);
        List<Integer> positive = numbers.stream().filter(a -> a > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}