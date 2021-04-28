import exceptions.EmptyGroupException;
import exceptions.LackOfMarksExceptions;
import exceptions.SomeExceptions;
import exceptions.ZeroDivisionException;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private final String nameFaculty;
    private List<Group> groups;

    public Faculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
        this.groups = new ArrayList<>();
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

    float getAverageMarksForFaculty(Group group, Subjects nameSubject) throws SomeExceptions, ZeroDivisionException, LackOfMarksExceptions, EmptyGroupException {
        if (groups.isEmpty()) {
            throw new SomeExceptions("No Groups added to the faculty" + getNameFaculty());
        }
        List<Integer> marks = group.getMarksForGroup(nameSubject);
        int sum = 0;
        float counter = 0;
        for (Integer mark : marks) {
            sum += mark;
            counter++;
        }
        if (counter == 0) {
            throw new ZeroDivisionException("Division by zero! No marks at the " + group + "in the " + nameSubject);
        }
        return (float) sum / counter;
    }
}
