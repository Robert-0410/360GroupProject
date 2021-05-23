package view;

import sql.Question;
import sql.QuestionManager;

import javax.swing.*;

/**
 * Game is ran from here.
 * @author Robert
 * @version 1
 */
public class Main {

    /**
     * main
     * @param args n/a
     */
    public static void main(String[] args) {
        //Force switch to universal UI theming.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        //
        final Game game = Game.getInstance();
        game.display();

        // this connects the database and has the database run as soon as the user starts the game
        QuestionManager questionManager = new QuestionManager();
        Question question = questionManager.getRandomMultipleChoiceQuestion();
    }
}
