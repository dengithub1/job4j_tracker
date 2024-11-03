package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;

public class ValidateInput implements Input {

    private final Output output;
    private final Input input;

    public ValidateInput(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        int value = -1;
        boolean invdalid = true;
        do {
            try {
                value = input.askInt(question);
                invdalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите корректные данные");
            }
        }
        while (invdalid);
        return value;
    }
}
