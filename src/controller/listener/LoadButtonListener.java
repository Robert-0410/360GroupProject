package controller.listener;

import controller.StatusManager;
import model.SavedGame;
import view.ButtonPanel;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadButtonListener extends GameListener {
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        var savedGame = new SavedGame();
        final var saved1 = "src/resources/saved_games/Save1.ser";

        // TODO: switch to decide what save game to load
        try {
            final var fileIn = new FileInputStream(saved1);
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
    }
}
