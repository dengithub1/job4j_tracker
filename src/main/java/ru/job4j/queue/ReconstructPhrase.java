package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder phrase = new StringBuilder();
        int evenCounter = 0;
        for (int i = 0; i < evenElements.size(); i++) {
            if (evenCounter % 2 == 0) {
                phrase.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
            i--;
            evenCounter++;
        }
        return phrase.toString();
    }

    private String getDescendingElements() {
        StringBuilder phrase = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            phrase.append(descendingElements.pollLast());
            i--;
        }
        return phrase.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
