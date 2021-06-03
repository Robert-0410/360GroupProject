package controller.listener;

import model.SavedGame;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Listener for the save game button.
 */
public class SaveGameButtonListener extends GameListener {
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        final var save1 = "src/resources/saved_games/Save1.ser";


        SavedGame beingSaved = new SavedGame();
        beingSaved.setMyMap(getEnvironmentManager().getMyMap());
        beingSaved.setMyUserRow(getEnvironmentManager().getMyUserRow());
        beingSaved.setMyUserCol(getEnvironmentManager().getMyUserCol());
        beingSaved.setMyUserLives(getEnvironmentManager().getPlayerLives());
        beingSaved.setInChildMode(getEnvironmentManager().getInChildMode());


        // TODO: switch statement decide what file is used

        try {

            final FileOutputStream fileOut = new FileOutputStream(save1);
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(beingSaved);
            out.close();

            fileOut.close();


        } catch (final IOException ex) {
            ex.printStackTrace();
        }

    }
}
