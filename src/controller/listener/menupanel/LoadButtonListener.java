package controller.listener.menupanel;

import controller.StatusManager;
import controller.listener.GameListener;
import model.SavedGame;
import view.ButtonPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Handles loading of game.
 * @author Robert & Sean
 */
public class LoadButtonListener extends GameListener {

    /**
     * The frame holding the Select button.
     */
    private final JFrame myFrame;

    public LoadButtonListener(final JFrame theFrame) {
        super();
        myFrame = theFrame;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        final JButton buttonClicked = (JButton) e.getSource();
        final var text = buttonClicked.getText();

        String load;
        switch (text) {
            case "Load 1" -> load = "src/resources/saved_games/Save1.ser";
            case "Load 2" -> load = "src/resources/saved_games/Save2.ser";
            case "Load 3" -> load = "src/resources/saved_games/Save3.ser";
            default -> {
                load = "src/resources/saved_games/SaveError.ser";
                System.err.println("Wrong string in LoadButtonListener.");
            }
        }


        var savedGame = new SavedGame();
        try {
            final var fileIn = new FileInputStream(load);
            final var in = new ObjectInputStream(fileIn);

            savedGame = (SavedGame) in.readObject();

        } catch (final IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return;
        }

        StatusManager.enableGameButtons();
        ButtonPanel.getInstance().addUserLives(savedGame.getMyUserLives());

        getEnvironmentManager().setStateFromSavedGame(savedGame.getMyMap(), savedGame.getMyUserRow(),
                savedGame.getMyUserCol(), savedGame.getMyUserLives(), savedGame.isInChildMode());
        getEnvironmentManager().generateAfterMove();

        // close frame
        myFrame.dispose();
    }
}
