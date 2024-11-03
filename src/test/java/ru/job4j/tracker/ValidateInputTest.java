package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{
                        "one", "1"
                }
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Введите пункт меню");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{
                        "2"
                }
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Введите пункт меню");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    void whenInputIsNegativeNumber() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{
                        "-3"
                }
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Введите пункт меню");
        assertThat(selected).isEqualTo(-3);
    }

    @Test
    void whenInputHaveTwoValidNumbers() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{
                        "-3", "1"
                }
        );
        ValidateInput input = new ValidateInput(output, in);
        int firstNumber = input.askInt("Введите пункт меню");
        int secondNumber = input.askInt("Введите пункт меню");
        assertThat(firstNumber).isEqualTo(-3);
        assertThat(secondNumber).isEqualTo(1);
    }
}