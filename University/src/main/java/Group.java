import java.util.ArrayList;

public class Group extends Faculty{
    private Student student;

    public Group() {
        super();
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Group{" +
                "student=" + student +
                '}';
    }
}
