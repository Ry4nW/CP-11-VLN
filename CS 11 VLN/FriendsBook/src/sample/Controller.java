package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Controller {
    public TextField nameField;
    public TextField ageField;
    public TextField specialtyField;
    public TextField groupField;
    public TextField newGroupField;

    public Button createFriendBtn;
    public Button deleteFriendBtn;
    public Button saveFriendsBtn;
    public Button deleteGroupBtn;
    public Button createGroupBtn;

    public Label friendLbl;
    public Label ageLbl;
    public Label specialtyLbl;

    public ListView<Friend> friendList = new ListView<>();
    public ArrayList<Group> totalGroups = new ArrayList<>();

    public Label friendErrorMessage;
    public Label groupErrorMessage;

    public ListView groups1;
    public ListView groups2;



    public void initialize() {

        deleteFriendBtn.setDisable(true);
        saveFriendsBtn.setDisable(true);
        deleteGroupBtn.setDisable(true);

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

                int age = Integer.parseInt(ageField.getText());

                if (age < 0 || age > 130) {
                    friendErrorMessage.setText("Invalid age.");
                } else {

                    String name = nameField.getText();
                    String specialty = specialtyField.getText();

                    Friend friend = new Friend(name, age, specialty);
                    totalGroups.get(group).friends.add(friend);

                    nameField.clear();
                    ageField.clear();
                    specialtyField.clear();
                    groupField.clear();

                    friendErrorMessage.setText("");

                    deleteFriendBtn.setDisable(true);
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
        friendList.getItems().remove(friendList.getSelectionModel().getSelectedItem());

        friendLbl.setText("");
        ageLbl.setText("");
        specialtyLbl.setText("");
    }

    public void displayFriend(MouseEvent mouseEvent) {
        deleteFriendBtn.setDisable(false);
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

    public void displayGroup(MouseEvent mouseEvent) throws ClassNotFoundException {
        friendList.getItems().clear();
        deleteGroupBtn.setDisable(false);

        int groupIndex = 0;

        for (int i = 0; i < totalGroups.size(); i++) {
            if (totalGroups.get(i).toString().equalsIgnoreCase(groups2.getSelectionModel().getSelectedItem().toString())) {
                groupIndex = i;
                break;
            }
        }

        for (Friend friend : totalGroups.get(groupIndex).friends) {
            friendList.getItems().add(friend);
        }


    }

    public void saveFriends(ActionEvent actionEvent) {
    }

    public void deleteGroup(ActionEvent actionEvent) {
    }
}
