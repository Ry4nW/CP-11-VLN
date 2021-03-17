import java.util.ArrayList;

public class Student {

    static ArrayList<Student> students = new ArrayList<>(); // Our ArrayList of students, which take {Student} objects.

    private String fName;
    private String lName;
    private int grade;
    private int studentNum;

    Student(String fName, String lName, int grade, int studentNum) {
        this.fName = fName;
        this.lName = lName;
        this.grade = grade;
        this.studentNum = studentNum;
    }

    // This loop iterates through the {students} ArrayList in order to print out all it's elements in our intended format.

    public static String getStudents() {

        String students = "";

        for (int i = 0; i < Student.students.size(); i++) {
            students += Student.students.get(i) + "\n";
        }

        return students;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    // Overrides the [toString()] method; prints out {Student} instance how we intend it to.

    @Override
    public String toString() {
        if (grade == 0) {
            return "Name: " + fName + " " + lName + ", Grade: " + "K";
        }
        return "Name: " + fName + " " + lName + ", Grade: " + grade;
    }

    public static void removeStudent(int studentIndex) { students.remove(studentIndex); } // Removes a student from ArrayList {students} based on index.
    public static void addStudent(Student student) { students.add(student); } // Adds a student to ArrayList {students} based on index.
}
