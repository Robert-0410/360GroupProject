package controller.listener;

import controller.GameAudio;
import model.CellType;
import view.ButtonPanel;
import view.Environment;
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
        if(userChoice == correctIndex && getEnvironmentManager().getIsWinningCell() == CellType.PORTAL) {
            GameAudio.winnerSong();
            ButtonPanel.getInstance().disableArrowButtons();
            QuestionPanel.getInstance().disableButtons();
            Environment.getInstance().gameWonEnvironmentPanel();
            Environment.getInstance().repaint();
            // reset isWinningCell
        } else if(userChoice == correctIndex) {
            getEnvironmentManager().removeDoorAfterCorrectAnswer();
            GameAudio.wubbaLubba();
        } else {
            final var currentLives = getEnvironmentManager().removeUserLife();
            if(currentLives >= 0) {
                ButtonPanel.getInstance().removeLifeCell(currentLives);
                GameAudio.wrongAnswer();
                getEnvironmentManager().removeDoorAfterWrongAnswer();
            } else {
                GameAudio.gameLost();
                ButtonPanel.getInstance().disableArrowButtons();
                QuestionPanel.getInstance().disableButtons();
                Environment.getInstance().gameLostEnvironmentPanel();
            }
        }
    }
}
