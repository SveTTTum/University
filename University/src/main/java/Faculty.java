public class Faculty {
        private String nameFaculty;
        private String nameGroup;

        public Faculty() {
            this.nameFaculty = nameFaculty;
            this.nameGroup = nameGroup;
        }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "nameFaculty='" + nameFaculty + '\'' +
                ", nameGroup='" + nameGroup + '\'' +
                '}';
    }
}
