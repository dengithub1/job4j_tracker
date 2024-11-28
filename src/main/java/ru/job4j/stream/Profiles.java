package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
        return result;
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        Comparator<Address> comparator = (o1, o2) -> o1.getCity().compareTo(o2.getCity());
        List<Address> result = profiles.stream()
                .map(Profile::getAddress)
                .sorted(comparator)
                .distinct()
                .collect(Collectors.toList());
        return result;
    }
}