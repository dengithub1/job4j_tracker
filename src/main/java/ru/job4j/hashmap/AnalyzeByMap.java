package ru.job4j.hashmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int element = 0;
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject s : pupil.subjects()) {
                element++;
                score += s.score();
            }
        }
        return score / element;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        int element = 0;
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject s : pupil.subjects()) {
                element++;
                score += s.score();
            }
            list.add(new Label(pupil.name(), score / element));
            element = 0;
            score = 0;
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> function = (oldValue, newValue) -> oldValue + newValue;
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), function);
            }
        }
        for (String key : map.keySet()) {
            int value = map.get(key);
            list.add(new Label(key, value / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(pupil.name(), score));
            score = 0;
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> function = (oldValue, newValue) -> oldValue + newValue;
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), function);
            }
        }
        for (String key : map.keySet()) {
            int value = map.get(key);
            list.add(new Label(key, value));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}