import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class University {
    private List<Faculty> faculties;

    public University(List<Faculty> faculties) {
//        if (faculties.isEmpty()) {
//            throw new IllegalArgumentException("No faculties added\n");
//        }
        this.faculties = faculties;

    }

    float getMiddleMarksForUniversity(String nameSubject) {
        ArrayList<Integer> marks = new ArrayList<>();
        for (Faculty faculty : faculties) {
            for (Group group : faculty.getGroups()) {
                marks.addAll(group.getMarksForGroup(nameSubject));
            }
        }
        int sum = 0;
        float counter = 0;
        for(Integer mark : marks) {
            sum += mark;
            counter++;
        }
        return (float) sum / counter;
    }

}
