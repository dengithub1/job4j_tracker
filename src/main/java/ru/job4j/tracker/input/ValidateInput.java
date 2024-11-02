package ru.job4j.tracker.input;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        int value = -1;
        boolean invdalid = true;
        do {
            try {
                value = super.askInt(question);
                invdalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
        }
        while (invdalid);
        return value;
    }
}
