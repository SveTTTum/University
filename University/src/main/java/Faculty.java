public class Faculty {
        private String nameFaculty;
        private Group nameGroup;

    public Faculty() {
        this.nameFaculty = nameFaculty;
        this.nameGroup = new Group();
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public Group getNameGroup() {
        return nameGroup;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public void setNameGroup(Group nameGroup) {
        this.nameGroup = nameGroup;
    }
}
