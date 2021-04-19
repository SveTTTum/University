import java.util.ArrayList;
import java.util.List;

public class Group {
    private String nameGroup;
    private List<Student> students = new ArrayList<>();

    public Group(String nameGroup) {
        this.nameGroup = nameGroup;
    }

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

    public void setStudents(List<Student> students) {
        this.students = students;

    }

    public ArrayList getMarksForGroup(String nameSubject) throws SomeExceptions {
        if (students.isEmpty()) {
            throw new SomeExceptions("No Students added to the group" + getNameGroup());
        } else {
            ArrayList<Integer> marks = new ArrayList<>();
            for (Student student : students) {
                marks.addAll(student.getMarks(nameSubject));
            }
            return marks;
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "nameGroup='" + nameGroup + '\'' +
                ", students=" + students +
                '}';
    }

}
