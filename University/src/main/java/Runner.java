import Exceptions.LackOfMarksExceptions;
import Exceptions.SomeExceptions;
import Exceptions.ZeroDivisionException;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) throws SomeExceptions, ZeroDivisionException, LackOfMarksExceptions {
        Student student1 = new Student("Nike Ivanov");
        student1.addSubjectAndMarks (Subjects.MATH, Arrays.asList(5, 7, 9, 7));
//5, 7, 9, 7
        student1.addSubjectAndMarks (Subjects.PHYSICS, Arrays.asList());
//8, 8, 9, 8
        student1.addSubjectAndMarks (Subjects.INFORMATICS, Arrays.asList());
//6, 8, 7, 8
        Student student2 = new Student("Mike Vazovsky");
        student2.addSubjectAndMarks (Subjects.MATH, Arrays.asList(5, 7, 9, 7));
        student2.addSubjectAndMarks (Subjects.PHYSICS, Arrays.asList(4, 6, 9, 7));
        student2.addSubjectAndMarks (Subjects.INFORMATICS, Arrays.asList(5, 8, 7, 6));
        Student student3 = new Student("Nina Pushkina");
        student3.addSubjectAndMarks (Subjects.MATH, Arrays.asList(8, 8, 9, 9));
        student3.addSubjectAndMarks (Subjects.PHYSICS, Arrays.asList(4, 5, 6, 7));
        student3.addSubjectAndMarks (Subjects.INFORMATICS, Arrays.asList(7, 6, 6, 6));
        Student student4 = new Student("Ivan Kotov");
        student4.addSubjectAndMarks (Subjects.MATH, Arrays.asList(8, 8, 8, 8));
        student4.addSubjectAndMarks (Subjects.PHYSICS, Arrays.asList(7, 7, 6, 6));
        student4.addSubjectAndMarks (Subjects.INFORMATICS, Arrays.asList(6, 6, 5, 5));
        try {
            System.out.println("Average score " + student1.getName() + " - " + student1.averageMarks());
        }
        catch (ArithmeticException e) {
            System.err.println("Division by zero!" + student1.getName() + " has no marks at the " + e);
        }
        //System.out.println(student1.getMarks(Subjects.INFORMATICS));
        Group groupA = new Group("A");
        Group groupB = new Group("B");
        Group groupC = new Group("C");
        groupA.setStudents(Arrays.asList(student1, student2));
        groupB.setStudents(Arrays.asList(student3));
        groupC.setStudents(Arrays.asList(student4));
        Faculty faculty1 = new Faculty("FPMI");
        Faculty faculty2 = new Faculty("FIFO");
        faculty1.setGroups(Arrays.asList(groupA, groupB));
        faculty2.setGroups(Arrays.asList(groupC));
        //System.out.println(groupA.getMarksForGroup("Math"));
        //System.out.println(groupB.getMarksForGroup("Math"));
        //System.out.println(faculty1.getAverageMarksForFaculty(groupA, "Math"));
        System.out.println("Cредний балл по конкретному предмету в конкретной группе и на конкретном факультете - " + faculty1.getAverageMarksForFaculty(groupB, Subjects.MATH));
        University university = new University();
        //university.setFaculties(Arrays.asList(faculty1, faculty2));
        try {
            System.out.println("Cредний балл по предмету для всего университета - " + university.getAverageMarksForAllFaculties(Subjects.PHYSICS));
        }
        catch (ZeroDivisionException e) {
            throw new ZeroDivisionException("Division by zero! University has no marks in the some Subject", e);
        }
        catch (LackOfMarksExceptions e) {
            System.err.println("No Faculties added to the University" + e.getCause());
        }

    }
}
