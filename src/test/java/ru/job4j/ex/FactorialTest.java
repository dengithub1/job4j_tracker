package ru.job4j.ex;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class FactorialTest {

    @Test
    void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Factorial().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    void whenFactorialIs5Than120() {
        int factorial = 5;
        int expected = 120;
        int result = new Factorial().calc(factorial);
        assertThat(result).isEqualTo(expected);
    }
}