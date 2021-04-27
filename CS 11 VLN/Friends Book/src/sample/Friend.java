package sample;

public class Friend {

    public String name;
    public int age;
    public String specialty;

    Friend(String n, int a, String s) {
        name = n;
        age = a;
        specialty = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String toString() {
        return name;
    }
}
