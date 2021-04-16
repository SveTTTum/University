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


}
