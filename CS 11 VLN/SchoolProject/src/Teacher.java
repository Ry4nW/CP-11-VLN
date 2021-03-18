import java.util.ArrayList;

public class Teacher {

    static ArrayList<Teacher> teachers = new ArrayList<>(); // Our ArrayList of teachers, which take {Teacher} objects.

    private String fName;
    private String lName;
    private String subject;

    public Teacher(String fName, String lName, String subject) {
        this.fName = fName;
        this.lName = lName;
        this.subject = subject;
    }

    // This loop iterates through the {teachers} ArrayList in order to print out all it's elements in our intended format.

    public static String getTeachers() {

        String teachers = "";

        for (int i = 0; i < Teacher.teachers.size(); i++) {
            teachers += (Teacher.teachers.get(i)) + "\n";
        }

        return teachers;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Overrides the [toString()] method; prints out {Teacher} instance how we intend it to.

    @Override
    public String toString() {
        return "Name: " + fName + " " + lName + ", Subject: " + subject;
    }

    public static void addTeacher(Teacher teacher) { teachers.add(teacher); } // Adds a teacher from ArrayList {teachers} based on index.
    public static void removeTeacher(int teacherIndex) { teachers.remove(teacherIndex); } // Removes a teacher from ArrayList {teachers} based on index.
}
