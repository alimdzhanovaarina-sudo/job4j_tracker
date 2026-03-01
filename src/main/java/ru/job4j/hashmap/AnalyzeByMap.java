package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double summa = 0;
            for (Subject subject : pupil.subjects()) {
                summa += subject.score();
            }
            double average = summa / pupil.subjects().size();
            result.add(new Label(pupil.name(), average));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), (double) subject.score(), Double::sum);
            }
            List<Label> result = new ArrayList<>();
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                String subjectName = entry.getKey();
                double totalScoreForSubject = entry.getValue();
                double averageScore = totalScoreForSubject / pupils.size();
                result.add(new Label(subjectName, averageScore));
            }
            return result;
        }
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentTotalScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            studentTotalScores.add(new Label(pupil.name(), totalScore));
        }
        studentTotalScores.sort(Comparator.naturalOrder());
        return studentTotalScores.get(studentTotalScores.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.merge(subject.name(), (double) subject.score(), Double::sum);
            }
        }
        List<Label> subjectTotalScores = new ArrayList<>();
        for (Map.Entry<String, Double> entry : subjectScores.entrySet()) {
            subjectTotalScores.add(new Label(entry.getKey(), entry.getValue()));
        }
        subjectTotalScores.sort(Comparator.naturalOrder());
        return subjectTotalScores.get(subjectTotalScores.size() - 1);
    }
}