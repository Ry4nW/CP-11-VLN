package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    public TextField nameField;
    public TextField ageField;
    public TextField specialtyField;

    public Button createFriendBtn;
    public Button deleteFriendBtn;

    public Label friendLbl;
    public Label ageLbl;
    public Label specialtyLbl;

    public ListView<Friend> friendList = new ListView<>();
    public Label errorMessage;

    public void createFriend(ActionEvent actionEvent) {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String specialty = specialtyField.getText();

        if (age < 0) {
            errorMessage.setText("Your friend's age cannot be less than 0.");
        } else {
            Friend friend = new Friend(name, age, specialty);
            friendList.getItems().add(friend);

            nameField.clear();
            ageField.clear();
            specialtyField.clear();

            errorMessage.setText("");

            deleteFriendBtn.setDisable(true);
        }

    }

    public void deleteFriend(ActionEvent actionEvent) {
        friendList.getItems().remove(friendList.getSelectionModel().getSelectedItem());

        friendLbl.setText("");
        ageLbl.setText("");
        specialtyLbl.setText("");
    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend friend = friendList.getSelectionModel().getSelectedItem();
        friendLbl.setText(friend.name);
        ageLbl.setText(Integer.toString(friend.age));
        specialtyLbl.setText(friend.specialty);
        deleteFriendBtn.setDisable(false);
    }
}
