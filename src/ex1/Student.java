package ex1;

public class Student implements Comparable<Student> {
    String firstName = "";
    String lastName = "";
    String id = "";
    String dateOfBirth = "";

    public Student(String firstName, String lastName, String id, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int compareTo(Student student) {
        if (this.id.equals(student.id))
            return 0;
        else if (Integer.parseInt(this.id) > Integer.parseInt(student.id))
            return 1;
        else
            return -1;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
