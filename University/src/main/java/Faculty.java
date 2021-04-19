import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Faculty {

        private String nameFaculty;
        private List<Group> groups;

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

        float getMiddleMarksForFaculty(Group group, String nameSubject) {
                ArrayList<Integer> marks = new ArrayList<>();
                marks.addAll(group.getMarksForGroup(nameSubject));

                int sum = 0;
                float counter = 0;
                for(Integer mark : marks) {
                        sum += mark;
                        counter++;
                }
                return (float) sum / counter;
        }

}
