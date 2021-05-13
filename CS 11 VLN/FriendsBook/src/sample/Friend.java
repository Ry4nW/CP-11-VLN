package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {

    public String name;
    public int age;
    public String specialty;
    public Group group;

    Friend(String n, int a, String s, String g) {
        name = n;
        age = a;
        specialty = s;
        group = new Group(g);
    }

    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("friends.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(name + ",\r");
        bw.write(age + ",\r");
        bw.write(specialty + ",\r");
        bw.write(group + ",\r");
        bw.write(";\r");

        bw.close();
    }

    public boolean checkFriend(Friend f) {
        return this.name.equals(f.name);
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
