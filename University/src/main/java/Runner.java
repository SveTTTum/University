import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws SomeExceptions {
        Student student1 = new Student("Nike Ivanov");
        student1.getDiary().addSubjectMark("Math", new Integer[]{5, 7, 9, 7});
        student1.getDiary().addSubjectMark("Physics", new Integer[]{8, 8, 9, 8});
        student1.getDiary().addSubjectMark("Informatics", new Integer[]{6, 8, 7, 8});
        Student student2 = new Student("Mike Vazovsky");
        student2.getDiary().addSubjectMark("Math", new Integer[]{5, 7, 9, 7});
        student2.getDiary().addSubjectMark("Physics", new Integer[]{4, 6, 9, 7});
        student2.getDiary().addSubjectMark("Informatics", new Integer[]{5, 8, 7, 6});
        Student student3 = new Student("Nina Pushkina");
        student3.getDiary().addSubjectMark("Math", new Integer[]{8, 8, 9, 9});
        student3.getDiary().addSubjectMark("Physics", new Integer[]{4, 5, 6, 7});
        student3.getDiary().addSubjectMark("Informatics", new Integer[]{7, 6, 6, 6});
        Student student4 = new Student("Ivan Kotov");
        student4.getDiary().addSubjectMark("Math", new Integer[]{8, 8, 8, 8});
        student4.getDiary().addSubjectMark("Physics", new Integer[]{7, 7, 6, 6});
        student4.getDiary().addSubjectMark("Informatics", new Integer[]{6, 6, 5, 5});
        System.out.println(student1.getDiary());
        System.out.println(student2.getDiary());
        System.out.println(student3.getDiary());
        System.out.println(student4.getDiary());
        System.out.println("Average score " + student1.getName() + " - " + student1.getDiary().MiddleMarks());
        //System.out.println("Average score at Math" + student2.getName() + " - " + student2.getDiary().MiddleSubjectMarks("Math"));
        //System.out.println(student2.getMarks("Informatics"));
//        Group groupA = new Group("A", Arrays.asList(student1, student2));
//        Group groupB = new Group("B", Arrays.asList(student3));
//        Group groupC = new Group("C", Arrays.asList(student4));
        Group groupA = new Group("A");
        Group groupB = new Group("B");
        Group groupC = new Group("C");
        groupA.setStudents(Arrays.asList(student1, student2));
        groupB.setStudents(Arrays.asList(student3));
        groupC.setStudents(Arrays.asList(student4));
//        Faculty faculty1 = new Faculty("FPMI", Arrays.asList(groupA, groupB));
//        Faculty faculty2 = new Faculty("FIFO", Arrays.asList(groupC));
        Faculty faculty1 = new Faculty("FPMI");
        Faculty faculty2 = new Faculty("FIFO");
        faculty1.setGroups(Arrays.asList(groupA, groupB));
        faculty2.setGroups(Arrays.asList(groupC));
        //System.out.println(groupA.getMarksForGroup("Math"));
        //System.out.println(groupB.getMarksForGroup("Math"));
        //System.out.println(faculty1.getMiddleMarksForFaculty(groupA, "Math"));
        System.out.println("Cредний балл по конкретному предмету в конкретной группе и на конкретном факультете - " + faculty2.getMiddleMarksForFaculty(groupB, "Math"));
        //University university = new University(Arrays.asList(faculty1, faculty2));
        University university = new University();
        //university.setFaculties(Arrays.asList(faculty1, faculty2));
        System.out.println("Cредний балл по предмету для всего университета - " + university.getMiddleMarksForUniversity("Physics"));

    }

}
