import java.util.ArrayList; // Imports Java's ArrayList and all it's needed methods.

public class School {

    static ArrayList<String> courses = new ArrayList<>(); // Our ArrayList of courses, which take strings.

    private String name;
    private String grades;
    private int studentAmount;

    School(String name, String grades, int studentAmount) {
        this.name = name;
        this.grades = grades;
        this.studentAmount = studentAmount;
    }

    //All setters and getters for all fields.

    public ArrayList<String> getCourses() {
        return courses;
    }
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGrades() {
        return grades;
    }
    public void setGrades(String grades) {
        this.grades = grades;
    }

    public int getStudentAmount() {
        return studentAmount;
    }
    public void setStudentAmount(int studentAmount) {
        this.studentAmount = studentAmount;
    }

    public static void addCourse(String course) { courses.add(course); } // Adds a String value to {courses} when invoked.

    // Overrides the [toString()] method in order to get our intended string when printing out our {School} instance.
    @Override
    public String toString() {
        return "Name: " + name + ", Grades: " + grades + ", Students: " + studentAmount;
    }

}
