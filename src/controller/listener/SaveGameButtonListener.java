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
        System.out.println("Save Game");
        final var save1 = "src/resources/saved_games/Save1.ser";


        SavedGame test = new SavedGame();
        test.setMyMap(getEnvironmentManager().getMyMap());
        test.setMyUserRow(getEnvironmentManager().getMyUserRow());
        test.setMyUserRow(getEnvironmentManager().getMyUserCol());
        test.setMyUserLives(getEnvironmentManager().getPlayerLives());
        test.setInChildMode(getEnvironmentManager().getInChildMode());
        test.checkObject();

        // TODO: switch statement decide what file is used

        try {

            final FileOutputStream fileOut = new FileOutputStream(save1);
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(test);
            out.close();

            fileOut.close();


        } catch (final IOException ex) {
            ex.printStackTrace();
        }

    }
}
