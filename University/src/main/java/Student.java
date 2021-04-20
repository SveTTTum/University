import Exceptions.LackOfMarksExceptions;
import Exceptions.SomeExceptions;
import Exceptions.ZeroDivisionException;

import java.util.ArrayList;
import java.util.*;


public class Student {

    private final String name;
    private Map<Subjects, List<Integer>> diary = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Map<Subjects, List<Integer>> diary) {
        this.name = name;
        this.diary = diary;
    }

    void addSubjectAndMarks (Subjects subject, List <Integer> marks) throws SomeExceptions {

        for (int mark : marks) {
            if (mark <= 0 || mark > 10) {
                throw new SomeExceptions("Incorrect mark in " + subject + " of "  + name + " , the mark must not be <= 0 or > 10");
            }
            // как-то предлагали заменить на СomputeIfAbsent() и СomputeIfPresent()
            diary.put(subject, new ArrayList<>());
            diary.get(subject).addAll(marks);
        }
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarksForSubject(Subjects subject) {
        return diary.get(subject);
    }

    // как тут упростить, чтобы сразу return ...?
    public List<Integer> getMarks(Subjects subject) throws LackOfMarksExceptions {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.addAll(getMarksForSubject(subject));
        return marks;


    }

    float averageMarks() throws ZeroDivisionException{
        int sum = 0;
        float counter = 0;
        for (Subjects subject : Subjects.values()) {
            for (int mark : diary.get(subject)) {
                sum += mark;
                counter++;
            }
        }
        if (counter == 0) {
            throw new ZeroDivisionException("Division by zero!" + getName() + " has no marks in the " + diary.keySet());
        }
        return sum / counter;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Subjects, List<Integer>> entry: diary.entrySet()) {
            stringBuilder.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return "Diary " + name + ":" +
                "\n" + stringBuilder.toString();
    }
}
