
import java.util.ArrayList;
import java.util.List;

public class Group {
    private String nameGroup;
    private List<Student> students;

    public Group(String nameGroup, List<Student> students) {
        this.nameGroup = nameGroup;
        this.students = students;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

}
