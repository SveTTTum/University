import java.util.ArrayList;

public class Student {
    //private static int id = 0;
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
}
