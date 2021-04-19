
import java.util.ArrayList;
import java.util.Collection;
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

    public ArrayList getMarksForGroup(String nameSubject) {
        ArrayList<Integer> marks = new ArrayList<>();
        for(Student student : students) {
            marks.addAll(student.getMarks(nameSubject));
        }
        return marks;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "nameGroup='" + nameGroup + '\'' +
                ", students=" + students +
                '}';
    }
}
