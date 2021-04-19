import java.util.*;

public class Diary {
    private String nameStudent;
    private final Map<String, List<Integer>> diary = new HashMap<>();

    Diary(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    void addSubject(String nameSubject) {
        diary.put(nameSubject, new ArrayList<>());
    }

    void addSubjectMark(String nameSubject, Integer[] marks) throws SomeExceptions {
        for (int mark : marks) {
            if (mark > 0 && mark <= 10) {
                addSubject(nameSubject);
                diary.get(nameSubject).addAll(Arrays.asList(marks));
            } else {
                throw new SomeExceptions("Incorrect mark...");
            }
        }
    }

    public List<Integer> getMarksForSubject(String nameSubject) {
        return diary.get(nameSubject);
    }

    double MiddleSubjectMarks(String nameSubject) {
        int sum = 0;
        int counter = 0;
        for (Integer mark : diary.get(nameSubject)) {
            sum += mark;
            counter++;
        }
        return (double) sum / counter;
    }

    float MiddleMarks() {
        int sum = 0;
        float counter = 0;
        for (String subject : diary.keySet()) {
            for (int mark : diary.get(subject)) {
                sum += mark;
                counter++;
            }
        }
        return sum / counter;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<Integer>> entry : diary.entrySet()) {
            stringBuilder.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return "Diary " + nameStudent + ":" +
                "\n" + stringBuilder.toString();
    }
}
