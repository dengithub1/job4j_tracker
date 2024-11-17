package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ItemComapeByNameTest {

    @Test
    void itemsSortedDesc() {
        List<Item> list = Arrays.asList(
                new Item("BCD"),
                new Item("ABC"),
                new Item("DEF")
        );
        Collections.sort(list, new ItemDescByName());
        List<Item> expectedList = Arrays.asList(
                new Item("ABC"),
                new Item("BCD"),
                new Item("DEF")
        );
        assertThat(list).containsExactlyElementsOf(expectedList);
    }

    @Test
    void itemsSortedAsc() {
        List<Item> list = Arrays.asList(
                new Item("ABC"),
                new Item("BCD"),
                new Item("DEF")
        );

        Collections.sort(list, new ItemAscByName());
        List<Item> expectedList = Arrays.asList(
                new Item("DEF"),
                new Item("BCD"),
                new Item("ABC")
        );
        assertThat(list).containsExactlyElementsOf(expectedList);
    }
}