package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class Controller {


    public static ArrayList createAllFriends(String fileName) throws IOException {

        ArrayList<Friend> friends = new ArrayList<>();

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;
        StringBuilder friendString = new StringBuilder();

        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                friendString.append(line);
            } else {
                friends.add(parseFriend(friendString.toString()));
                friendString = new StringBuilder();
            }

        }

        return friends;
    }

    private static Friend parseFriend(String str) {


        int p = 0;
        String name = "";
        String age = "";
        String specialty = "";
        String group = "";

        int j = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {

                switch (j) {
                    case 0:
                        name = str.substring(p, i);
                        break;
                    case 1:
                        age = str.substring(p + 1, i);
                        break;
                    case 2:
                        specialty = str.substring(p + 1, i);
                        break;
                    case 3:
                        group = str.substring(p + 1, i);
                        break;
                }

                p = i;
                j++;
            }
        }

        Friend friend = new Friend(name, Integer.parseInt(age), specialty, group);

        try {
            if (loadFriendField.getText().length() == 0 || group.equals(loadFriendField.getText())) {
                return friend;
            }

        } catch (Exception NullPointerException) {
            return friend;
        }
        return friend;

    }


    public TextField nameField;
    public TextField ageField;
    public TextField specialtyField;
    public TextField groupField;
    public TextField newGroupField;
    public static TextField loadFriendField;

    public Button createFriendBtn;
    public Button deleteFriendBtn;
    public Button saveFriendsBtn;
    public Button deleteGroupBtn;
    public Button createGroupBtn;
    public Button loadFriendBtn;

    public Label friendLbl;
    public Label ageLbl;
    public Label specialtyLbl;

    public ListView<Friend> friendList = new ListView<>();
    public static ArrayList<Group> totalGroups = new ArrayList<>();

    public Label friendErrorMessage;
    public Label groupErrorMessage;
    public Label saveMessage;

    public ListView<Group> groups1;
    public ListView<Group> groups2;

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void initialize() throws IOException {

        deleteFriendBtn.setDisable(true);
        saveFriendsBtn.setDisable(true);
        deleteGroupBtn.setDisable(true);

        FileReader fr = new FileReader("friends.txt");
        BufferedReader br = new BufferedReader(fr);

        if (br.readLine() == null) {
            loadFriendBtn.setDisable(true);
        }

    }

    public void createFriend() {

        friendErrorMessage.setText("");

        if (nameField.getText().length() != 0 && ageField.getText().length() != 0 && specialtyField.getText().length() != 0 && groupField.getText().length() != 0) {

            int group = -1;

            for (int i = 0; i < totalGroups.size(); i++) {
                if (totalGroups.get(i).toString().equalsIgnoreCase(groupField.getText())) {
                    group = i;
                    break;
                }
            }

            if (group != -1) {

                String ageTest = ageField.getText();

                if (!isInteger(ageTest) || (Integer.parseInt(ageTest) < 0 || Integer.parseInt(ageTest) > 130)) {
                    friendErrorMessage.setText("Invalid age.");
                } else {

                    String name = nameField.getText();
                    int age = Integer.parseInt(ageTest);
                    String specialty = specialtyField.getText();
                    String g = groupField.getText();

                    Friend friend = new Friend(name, age, specialty, g);
                    totalGroups.get(group).friends.add(friend);

                    nameField.clear();
                    ageField.clear();
                    specialtyField.clear();
                    groupField.clear();

                    friendErrorMessage.setText("");

                    deleteFriendBtn.setDisable(true);
                    saveFriendsBtn.setDisable(false);
                    friendErrorMessage.setText("Created " + friend.name + ".");
                }
            } else {
                friendErrorMessage.setText("Invalid group.");
            }

        } else {
            friendErrorMessage.setText("Invalid input.");
        }

    }

    public void deleteFriend(ActionEvent actionEvent) {
        deleteFriendBtn.setDisable(true);
        groups2.getSelectionModel().getSelectedItem().friends.remove(friendList.getSelectionModel().getSelectedItem());
        friendList.getItems().remove(friendList.getSelectionModel().getSelectedItem());

        friendLbl.setText("");
        ageLbl.setText("");
        specialtyLbl.setText("");
    }

    public void displayFriend(MouseEvent mouseEvent) {
        deleteFriendBtn.setDisable(false);
        saveFriendsBtn.setDisable(false);
        loadFriendBtn.setDisable(false);

        Friend friend = friendList.getSelectionModel().getSelectedItem();

        friendLbl.setText(friend.name);
        ageLbl.setText(Integer.toString(friend.age));
        specialtyLbl.setText(friend.specialty);
        deleteFriendBtn.setDisable(false);
    }

    public void createGroup(ActionEvent actionEvent) {

        if (newGroupField.getText().length() == 0) {
            groupErrorMessage.setText("Enter a name for your group.");
        } else {

            groupErrorMessage.setText("");
            Group group = new Group(newGroupField.getText());

            totalGroups.add(group);
            groups1.getItems().add(group);
            groups2.getItems().add(group);

            newGroupField.clear();

        }

    }

    public void displayGroup(MouseEvent mouseEvent) {
        friendList.getItems().clear();
        deleteGroupBtn.setDisable(false);

        int groupIndex = 0;

        for (int i = 0; i < totalGroups.size(); i++) {
            if (totalGroups.get(i).toString().equalsIgnoreCase(groups2.getSelectionModel().getSelectedItem().toString())) {
                groupIndex = i;
                break;
            }
        }

        for (Friend friend : groups2.getSelectionModel().getSelectedItem().friends) {
            friendList.getItems().add(friend);
        }

        friendLbl.setText("");
        ageLbl.setText("");
        specialtyLbl.setText("");

    }

    public void saveFriends(ActionEvent actionEvent) throws IOException {
        FileWriter fw = new FileWriter("friends.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        if (groups2.getItems().isEmpty()) {
            bw.write("");
            bw.close();
            saveMessage.setText("Friends successfully reset.");
            saveFriendsBtn.setDisable(true);
            deleteFriendBtn.setDisable(true);
        } else if (groups2.getSelectionModel().getSelectedItem().friends.isEmpty()) {
            bw.write("");
            bw.close();
            saveFriendsBtn.setDisable(true);
            deleteFriendBtn.setDisable(true);
        } else {
            ObservableList<Group> list = groups2.getItems();

            bw.write("");
            bw.close();
            for (Group group : list) {
                for (Friend friend : group.friends) {
                    friend.writeToFile();
                }

            }

            for (Group group : list) {
                group.friends.clear();
            }

            groups1.getItems().clear();
            groups2.getItems().clear();
            totalGroups.clear();
            friendList.getItems().clear();

            friendLbl.setText("");
            ageLbl.setText("");
            specialtyLbl.setText("");
            saveMessage.setText("Friends successfully saved!");
        }

        loadFriendBtn.setDisable(false);
        deleteFriendBtn.setDisable(false);
    }

    public void deleteGroup(ActionEvent actionEvent) {

        friendLbl.setText("");
        ageLbl.setText("");
        specialtyLbl.setText("");

        for (int i = 0; i < totalGroups.size(); i++) {
            if (groups2.getSelectionModel().getSelectedItem().equals(totalGroups.get(i))) {
                totalGroups.remove(i);
                break;
            }
        }

        friendList.getItems().clear();
        groups1.getItems().remove(groups2.getSelectionModel().getSelectedItem());
        groups2.getItems().remove(groups2.getSelectionModel().getSelectedItem());

        deleteGroupBtn.setDisable(true);

    }

    public void loadFriends(ActionEvent actionEvent) throws IOException {
        loadFriendBtn.setDisable(true);

        saveMessage.setText("");
        groups2.getItems().clear();
        groups1.getItems().clear();
        friendList.getItems().clear();
        try {
            loadFriendField.clear();
        } catch (Exception NullPointException) {
            loadFriendBtn.setDisable(true);
        }

        ArrayList<Friend> friends = createAllFriends("friends.txt");

        for (Friend f : friends) {
            groups2.getItems().add(f.group);
            groups1.getItems().add(f.group);


            for (int i = 0; i < totalGroups.size(); i++) {
                if (totalGroups.get(i).equals(f.group)) {
                    f.group.friends.add(f);
                    break;
                } else if (i == (totalGroups.size() - 1)){
                    totalGroups.add(f.group);
                    f.group.friends.add(f);
                    break;
                }
            }



        }


    }
}
