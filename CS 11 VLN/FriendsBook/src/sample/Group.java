package sample;

import java.util.ArrayList;

public class Group {

    public String name;
    public ArrayList<Friend> friends = new ArrayList<>();

    Group(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}
