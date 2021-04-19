import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private String nameFaculty;
    private List<Group> groups = new ArrayList<>();


    public Faculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public Faculty(String nameFaculty, List<Group> groups) {
        this.nameFaculty = nameFaculty;
        this.groups = groups;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    float getMiddleMarksForFaculty(Group group, String nameSubject) throws SomeExceptions {
        if (groups.isEmpty()) {
            throw new SomeExceptions("No Groups added to the faculty" + getNameFaculty());
        } else {
            ArrayList<Integer> marks = new ArrayList<>();
            marks.addAll(group.getMarksForGroup(nameSubject));

            int sum = 0;
            float counter = 0;
            for (Integer mark : marks) {
                sum += mark;
                counter++;
            }
            return (float) sum / counter;
        }
    }
}
