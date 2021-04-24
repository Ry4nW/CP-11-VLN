package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Controller {

    public TabPane tabPane;

    public Tab menuChoiceTab;
    public Tab gameDisplayTab;

    public Button playComputerBtn;
    public Button roll1;
    public Button roll2;

    public Label label1;
    public Label label2;

    public Label message1;
    public Label message2;
    public Label current1;
    public Label current2;
    public Label title;
    public Button exitBtn;


    public void initialize() {

        tabPane.getTabs().remove(gameDisplayTab);

        current1.setVisible(false);
        current2.setVisible(false);
    }

    public void playComputer(ActionEvent actionEvent) {

        tabPane.getTabs().add(gameDisplayTab);
        tabPane.getTabs().remove(menuChoiceTab);

        label1.setText("You");
        label2.setText("Computer");
        message2.setText("");
        current1.setText("Current: 0");
        current2.setText("Current: 0");

        message1.setVisible(true);
        message2.setVisible(true);
        current1.setVisible(true);
        current2.setVisible(true);

        message1.setText("Your turn! Roll the dice.");
        roll2.setDisable(true);
        roll1.setDisable(false);

    }

    public void player1Roll(ActionEvent actionEvent) {

        roll1.setDisable(true);

        int dice = ((int) Math.floor(Math.random() * (6 - 1 + 1) + 1));

        int t;

        if (current1.getText().length() == 10) {
            t = dice + Integer.parseInt(current1.getText().substring(current1.getText().length() - 1));
        } else {
            t = dice + Integer.parseInt(current1.getText().substring(current1.getText().length() - 2));
        }

        if (t > 100) {

            message1.setText("You rolled a " + dice + " to " + t + ". You must roll to \n exactly 100 in order to win.");

        } else if (t == 100) {

            tabPane.getTabs().remove(gameDisplayTab);
            tabPane.getTabs().add(menuChoiceTab);
            current1.setVisible(false);
            current2.setVisible(false);
            message1.setVisible(false);
            message2.setVisible(false);

            title.setText("You win!");

        } else if (t == 1 || t == 4 || t == 8 || t == 28 || t == 21 || t == 50 || t == 71 || t == 80) {

            // Test cases for ladders, enhanced switch case not supported by Java 8 :(
            if (t == 1)
                current1.setText("Current: 38");
            else if (t == 4)
                current1.setText("Current: 14");
            else if (t == 8)
                current1.setText("Current: 30");
            else if (t == 28)
                current1.setText("Current: 76");
            else if (t == 21)
                current1.setText("Current: 42");
            else if (t == 50)
                current1.setText("Current: 67");
            else if (t == 71)
                current1.setText("Current: 92");
            else if (t == 80)
                current1.setText("Current: 99");

            message1.setText("You rolled a " + dice + " to a ladder at " + t + ".");

        } else if (t == 32 || t == 36 || t == 48 || t == 62 || t == 88 || t == 95 || t == 97) {

            // Test cases for snakes
            if (t == 32)
                current1.setText("Current: 10");
            else if (t == 36)
                current1.setText("Current: 6");
            else if (t == 48)
                current1.setText("Current: 26");
            else if (t == 62)
                current1.setText("Current: 18");
            else if (t == 88)
                current1.setText("Current: 24");
            else if (t == 95)
                current1.setText("Current: 56");
            else if (t == 97)
                current1.setText("Current: 78");

            message1.setText("You rolled a " + dice + " to a snake at " + t + ".");

        } else {
            // Regular square
            message1.setText("You rolled a " + dice + ".");
            current1.setText("Current: " + t);
        }

        message2.setText("Roll the dice for the computer.");
        roll2.setDisable(false);
    }


    public void computerRoll(ActionEvent actionEvent) {

        roll2.setDisable(true);
        roll1.setDisable(false);

        int dice = ((int) Math.floor(Math.random() * (6 - 1 + 1) + 1));

        int t;

        if (current2.getText().length() == 10) {
            t = Integer.parseInt(current2.getText().substring(current2.getText().length() - 1)) + dice;
        } else {
            t = Integer.parseInt(current2.getText().substring(current2.getText().length() - 2)) + dice;
        }

        if (t > 100) {
            message2.setText("You rolled a " + dice + " to " + t + ". Computer must roll to \n exactly 100 in order to win.");
        } else if (t == 100) {

            tabPane.getTabs().remove(gameDisplayTab);
            tabPane.getTabs().add(menuChoiceTab);
            current1.setVisible(false);
            current2.setVisible(false);
            message1.setVisible(false);
            message2.setVisible(false);


            title.setText("Computer wins.");

        } else if (t == 1 || t == 4 || t == 8 || t == 28 || t == 21 || t == 50 || t == 71 || t == 80) {

                // Test cases for ladders
            if (t == 1)
                current2.setText("Current: 38");
            else if (t == 4)
                current2.setText("Current: 14");
            else if (t == 8)
                current2.setText("Current: 30");
            else if (t == 28)
                current2.setText("Current: 76");
            else if (t == 21)
                current2.setText("Current: 42");
            else if (t == 50)
                current2.setText("Current: 67");
            else if (t == 71)
                current2.setText("Current: 92");
            else if (t == 80)
                current2.setText("Current: 99");

            message2.setText("You rolled a " + dice + " to a ladder at " + t + ".");

        } else if (t == 32 || t == 36 || t == 48 || t == 62 || t == 88 || t == 95 || t == 97) {

            if (t == 32)
                current2.setText("Current: 10");
            else if (t == 36)
                current2.setText("Current: 6");
            else if (t == 48)
                current2.setText("Current: 26");
            else if (t == 62)
                current2.setText("Current: 18");
            else if (t == 88)
                current2.setText("Current: 24");
            else if (t == 95)
                current2.setText("Current: 56");
            else if (t == 97)
                current2.setText("Current: 78");

            message2.setText("You rolled a " + dice + " to a snake at " + t + ".");

            } else {
                message2.setText("You rolled a " + dice + ".");
                current2.setText("Current: " + t);
        }

        message1.setText("Roll the dice for yourself.");
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}











