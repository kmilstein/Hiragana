/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oaklandcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ksenia
 */
public class FXMLController implements Initializable {

    @FXML
    private Label characterLabel;
    @FXML
    private TextField answerTextField;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button submitButton;
    int score;
    int guesses;
    int randomNumber;
    String currentHiraganaCharacter;
    String currentEnglishCharacter;

    ArrayList<Character> list = new ArrayList<>();
    Random rand = new Random();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Scanner infile;
            infile = new Scanner(new File("hiragana.txt"));
            while (infile.hasNext()) {
                list.add(new Character(infile.next(), infile.next()));
            }
            infile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        randomNumber = rand.nextInt(list.size());
        currentHiraganaCharacter = list.get(randomNumber).getHiraganaCharacter();
        characterLabel.setText(currentHiraganaCharacter);
    }

    @FXML
    private void submitAnswer(MouseEvent event) {
        currentEnglishCharacter = answerTextField.getText();
        if (currentEnglishCharacter.equals(list.get(randomNumber).getEnglishCharacter())) {
            score++;
            guesses++;
            list.remove(randomNumber);
            scoreLabel.setText("You got it right!");
        }
        else {
            guesses++;
            scoreLabel.setText("You got it wrong.");
        }
        randomNumber = rand.nextInt(list.size());
        currentHiraganaCharacter = list.get(randomNumber).getHiraganaCharacter();
        if (list.isEmpty()) {
            scoreLabel.setText("Please click the reset button");
        }
        else {
        characterLabel.setText(currentHiraganaCharacter);
        }
        
        if (guesses == 10) {
            submitButton.setDisable(true);
            scoreLabel.setText("You've got "+score+ " correct out of 10!");
        }
    }

    @FXML
    private void onReset(ActionEvent event) {
        score = 0;
        guesses = 0;
        scoreLabel.setText("");
        submitButton.setDisable(false);
    }

    @FXML
    private void onClose(ActionEvent event) {
        System.exit(0);
    }
}
