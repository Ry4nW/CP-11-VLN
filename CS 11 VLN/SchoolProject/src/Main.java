public class Main {

    public static void main(String[] args) {

        School theSchool = new School("The School", "K-12", Student.students.size()); // Creates a new instance of the {School} class.

        String[] subjects = {"Calculus", "Social Studies", "PE", "Computer Science", "Physics", "English Language Arts"};

        // 10 new instances of the {Student} class.

        Student John = new Student("John", "Smith", (int) (Math.random() * 12)/* Random number between 0-12 for {grade}.*/, (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));
        Student Ryan = new Student("Ryan", "Wang", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000))/* Another random number between 1mil-9mil for {studentNum}.*/;
        Student Niel = new Student("Niel", "Ganguli", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));
        Student Nelson = new Student("Nelson", "Rockford", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));
        Student Joseph = new Student("Joseph", "Edwardo", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));
        Student Elizabeth = new Student("Elizabeth", "Chan", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));
        Student Sophia = new Student("Sophia", "Maywater", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));
        Student Jessica = new Student("Jessica", "Davis", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));
        Student Amy = new Student("Amy", "Argarwal", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));
        Student Rachel = new Student("Rachel", "Lee", (int) (Math.random() * 12), (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000));

        // 3 new instances of the {Teacher} class.

        Teacher Tobey = new Teacher("Tobey", "Steeves", subjects[(int) (Math.random() * 6)]);
        Teacher Nhat = new Teacher("Nhat", "Dao", subjects[(int) (Math.random() * 6)]);
        Teacher Karla = new Teacher("Karla", "Smedley", subjects[(int) (Math.random() * 6)]);

        Student[] students = {John, Ryan, Niel, Nelson, Joseph, Elizabeth, Sophia, Jessica, Amy, Rachel};
        Teacher[] teachers = {Nhat, Tobey, Karla};

        for (Student student : students) {
            Student.addStudent(student);
        }

        for (Teacher teacher : teachers) {
            Teacher.addTeacher(teacher);
        }

        // For loops above iterate through {students} and {teachers} to add all instances of the {Student}/{Teacher} classes into the ArrayLists of students and teachers, in each class, respectively.

        for (String subject : subjects) {
            School.addCourse(subject);
        }

        theSchool.setStudentAmount(Student.students.size()); // Sets the updated amount of objects that take the {Student} class.
        System.out.println(theSchool + "\n\n**ALL COURSES**\n" + School.courses);

        System.out.println("\n**ALL TEACHERS**\n" + Teacher.getTeachers() + "\n**ALL STUDENTS**\n" + Student.getStudents());

        // Removes {John} and {Ryan}, both at index 0, since {Ryan} would be at index 0 after {John} is removed.
        Student.removeStudent(0);
        Student.removeStudent(0);

        // Removes {Karla} at index 2.
        Teacher.removeTeacher(2);

        theSchool.setStudentAmount(Student.students.size());
        System.out.println(theSchool);

        System.out.println("\n**ALL TEACHERS 1.1**\n" + Teacher.getTeachers() + "\n**ALL STUDENTS 1.1**\n" + Student.getStudents());
    }
}
