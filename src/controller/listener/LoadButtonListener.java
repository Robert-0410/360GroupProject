package controller.listener;

import model.SavedGame;

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
        // TODO: set the environmentManager and load map.
        getEnvironmentManager().setStateFromSavedGame(savedGame.getMyMap(), savedGame.getMyUserRow(),
                savedGame.getMyUserCol(), savedGame.getMyUserLives(), savedGame.isInChildMode());
        getEnvironmentManager().generateAfterMove();
        System.out.println("finished Load");
    }
}
