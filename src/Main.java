import ex1.AssociationTable;
import ex1.IllegalArgumentException;
import ex1.Student;

/*
    @author: Israel Heiblum
 */

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("Hello Maman 14 EX1");
        System.out.println("--------------------------------------------------------------------------------");

        Student s1 = new Student("Srul", "Heiblum", "2", "27.09.88");
        Student s2 = new Student("Leo", "Igel", "3", "01.10.88");
        Student s3 = new Student("Inbal", "Oved", "4", "08.01.89");
        Student s4 = new Student("Dudu", "Topaz", "1", "22.01.75");
        Student[] students = {s1, s2, s3, s4};

        String[] phones = {"0525", "0523", "0503", "050555"};

        AssociationTable<Student, String> associationTable = new AssociationTable<>(students, phones);

        Student s5 = new Student("Tal", "Mosseri", "5", "22.08.81");
        associationTable.add(s5, "0506666666"); // Add new student s5

        for (Student student : associationTable) { // print using iterator
            System.out.println(student);
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(associationTable.get(s1));
        associationTable.add(s1, "0525322167"); // Edit student s1
        System.out.println(associationTable.get(s1));

        associationTable.remove(s2); // Remove student s2

        System.out.println("--------------------------------------------------------------------------------");

        for (Student student : associationTable) { // print using iterator
            System.out.println(student);
        }


    }
}
