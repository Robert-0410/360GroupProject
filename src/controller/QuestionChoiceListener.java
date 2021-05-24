package controller;

import view.QuestionPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Listens for answer choices done by the user and verifies if correct.
 * @author Robert
 * @version 1
 */
public class QuestionChoiceListener extends GameListener {


    /**
     * Used for the question choice buttons.
     */
    public QuestionChoiceListener() {
        super();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        System.out.println("Question Button was pressed.");
        final var question = QuestionPanel.getInstance().getMyQuestion();
        int userChoice = -1;
        final var correctIndex = question.getMyCorrectIndex();
        final var buttonChoice = (JButton)e.getSource();
        final var letterChoice = buttonChoice.getText();

        switch (letterChoice) {
            case "A" -> userChoice = 0;
            case "B" -> userChoice = 1;
            case "C" -> userChoice = 2;
            case "D" -> userChoice = 3;
        }
        if(userChoice == correctIndex) {
            System.out.println("Correct");
            getEnvironmentGenerator().removeDoorAfterCorrectAnswer();
        } else {
            System.out.println("Wrong, player should loose life");
        }

    }
}
