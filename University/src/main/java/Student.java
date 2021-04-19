import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String name;
    private final Diary diary;

    Student(String name) {
        this.name = name;
        this.diary = new Diary(name);
    }

    public Diary getDiary() {
        return diary;
    }

    public String getName() {
        return name;
    }

    public ArrayList getMarks(String nameSubject) {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.addAll(diary.getMarksForSubject(nameSubject));
        return marks;
    }

    public void setNameStudent(String name) {
        this.name = name;
    }
}
