public class Student extends Group{
    private static int id = 0;
    private final Diary diary;

    Student() {
        super();
        id++;
        this.diary = new Diary(id);
    }

    public Diary getDiary() {
        return diary;
    }

}
