
import exceptions.SomeExceptions;
import exceptions.ZeroDivisionException;
import java.util.*;


public class Student {

    private final String name;
    private final Map<Subjects, List<Integer>> diary;

    public Student(String name) {
        this.name = name;
        this.diary = new HashMap<>();
    }

    void addSubjectAndMarks (Subjects subject, List <Integer> marks) throws SomeExceptions {
        for (int mark : marks) {
            if (mark <= 0 || mark > 10) {
                throw new SomeExceptions("Incorrect mark in " + subject + " of " + name + " , the mark must not be <= 0 or > 10");
            }
        }
        diary.putIfAbsent(subject, marks);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarksForSubject(Subjects subject) {
        return diary.get(subject);
    }

    public List<Integer> getMarks(Subjects subject) {
        return getMarksForSubject(subject);
    }

    float calculateAverageMarks() throws ZeroDivisionException, SomeExceptions {
        int sum = 0;
        float counter = 0;
        for (Subjects subject : Subjects.values() ) {
            if (diary.containsKey(subject)) {
                for (int mark : diary.get(subject)) {
                    sum += mark;
                    counter++;
                }
            }
            else
                throw new SomeExceptions(subject + " is not in diary of " + getName());
        }
        if (counter == 0) {
            throw new ZeroDivisionException("Division by zero!" + getName() + " has no marks at the " + diary.keySet());
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
