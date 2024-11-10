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
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                phrase.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return phrase.toString();
    }

    private String getDescendingElements() {
        StringBuilder phrase = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            phrase.append(descendingElements.pollLast());
        }
        return phrase.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
