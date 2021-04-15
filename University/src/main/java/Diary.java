import java.util.*;

public class Diary {
    private final int studentId;
    private final Map<String, List<Integer>> diary = new HashMap<>();

    Diary(int studentId) {
        this.studentId = studentId;
    }

    void addSubject(String nameSubject) {
        diary.put(nameSubject, new ArrayList<>());
    }

    void addSubjectMark(String nameSubject, Integer [] marks) {
        addSubject(nameSubject);
        diary.get(nameSubject).addAll(Arrays.asList(marks));
    }

    long MiddleSubjectMarks(String nameSubject) {
        int sum = 0;
        int counter = 0;
        for(Integer mark: diary.get(nameSubject)) {
            sum += mark;
            counter++;
        }
        return sum/ counter;
    }

    long MiddleMarks() {
        int sum = 0;
        int counter = 0;
        for(String subject: diary.keySet()) {
            for(int mark: diary.get(subject)) {
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
        return "Diary student" + studentId + ":" +
                "\n" + stringBuilder.toString();
    }
}
