/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.io.File;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
 import javafx.stage.Stage;

/**
 * Stacey Lawson
 * 1181-06L
 * Extra Credit - Rock Paper Scissors
 */
public class RockPaperScissors extends Application {

    private Label label;
    private Label label2;
    private Button b1;
    private Button b2;
    private Button b3;
    private int playerSelection;
    private int computerSelection;
    private String result;
    private GridPane mainPane;
    private Button computer;
    private Label label3;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainPane = new GridPane();

        label = new Label();
        label2 = new Label();

        label.setText("Choose your weapon!");
        b1 = new Button();
        b1.setGraphic(new ImageView(new Image(new File("paper.jpeg").toURI().toString())));
        mainPane.add(label, 0, 0);
        mainPane.add(b1, 0, 1);
        mainPane.add(label2, 0, 3);
        computer = new Button();
        mainPane.add(computer, 0, 5);
        computer.setVisible(false);
        label3 = new Label();
        mainPane.add(label3, 0, 7, 2, 1);

        b1.setOnAction(e
                -> {
            playerSelection = 1;
            getComputerSelection();
            playGame();
            label3.setText(result);

        });

        b2 = new Button();
        b2.setGraphic(new ImageView(new Image(new File("scissors.png").toURI().toString())));
        mainPane.add(b2, 1, 1);

        b2.setOnAction(e
                -> {
            playerSelection = 2;
            getComputerSelection();
            playGame();
            label3.setText(result);
        });

        b3 = new Button();
        b3.setGraphic(new ImageView(new Image(new File("rock.png").toURI().toString())));
        mainPane.add(b3, 2, 1);
        b3.setOnAction(e
                -> {
            playerSelection = 3;
            getComputerSelection();
            playGame();
            label3.setText(result);

        });

        Scene scene = new Scene(mainPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public int getComputerSelection() {
        Random number = new Random();
        label2.setText("I choose");
        computerSelection = number.nextInt(3) + 1;
        if (computerSelection == 1) {

            computer.setGraphic(new ImageView(new Image(new File("paper.jpeg").toURI().toString())));
            computer.setVisible(true);

        } else if (computerSelection == 2) {
            computer.setGraphic(new ImageView(new Image(new File("scissors.png").toURI().toString())));
            computer.setVisible(true);

        } else if (computerSelection == 3) {
            computer.setGraphic(new ImageView(new Image(new File("rock.png").toURI().toString())));
            computer.setVisible(true);

        }

        return computerSelection;
    }

    public String playGame() {

        if ((playerSelection == 1 && computerSelection == 3)
                || (playerSelection == 2 && computerSelection == 1)
                || (playerSelection == 3 && computerSelection == 2)) {
            result = "You have triumphed!";
        } else if ((playerSelection == 1 && computerSelection == 2)
                || (playerSelection == 2 && computerSelection == 3)
                || (playerSelection == 3 && computerSelection == 1)) {
            result = "You have been vanquished!";
        } else {
            result = "We are evenly matched!";
        }

        return result;
    }

}
