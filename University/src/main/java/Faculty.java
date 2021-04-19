import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Faculty {

        private String nameFaculty;
        private List<Group> groups;

        public Faculty(String nameFaculty) {
                this.nameFaculty = nameFaculty;
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

        float getMiddleMarksForFaculty(Group group, String nameSubject) {
                if (nameFaculty.isEmpty()) {
                        throw new NullPointerException("No Groups added\n");
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
