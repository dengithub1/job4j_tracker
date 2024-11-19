package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenJobDescByNameTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Work", 1),
                new Job("Sleep", 2),
                new Job("Drink", 3)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Drink", 3),
                new Job("Sleep", 2),
                new Job("Work", 1)
        );
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    void whenJobAscByNameTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Work", 234),
                new Job("Sleep", 13),
                new Job("Drink", 0)
        );
        Collections.sort(jobs, new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Work", 234),
                new Job("Sleep", 13),
                new Job("Drink", 0)
        );
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    void whenJobDecByPriorityTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Work", 234),
                new Job("Sleep", 0),
                new Job("Drink", 23)
        );

        Collections.sort(jobs, new JobDescByPriotity());
        List<Job> expected = Arrays.asList(
                new Job("Sleep", 0),
                new Job("Drink", 23),
                new Job("Work", 234)
        );
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    void whenJobAscByPriorityTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Work", 234),
                new Job("Sleep", 0),
                new Job("Drink", 23)
        );
        Collections.sort(jobs, new JobAscByPriotity());
        List<Job> expected = Arrays.asList(
                new Job("Work", 234),
                new Job("Drink", 23),
                new Job("Sleep", 0)
        );
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    void whenComparatorByNameAndPriorityIsGreaterTest() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriotity());
        int rsl = cmp.compare(
                new Job("Work", 234),
                new Job("Work", 23)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenComparatorByNameAndPriorityIsLowerTest() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriotity());
        int rsl = cmp.compare(
                new Job("Work", 5),
                new Job("Work", 6)
        );
        assertThat(rsl).isLessThan(0);
    }
}
