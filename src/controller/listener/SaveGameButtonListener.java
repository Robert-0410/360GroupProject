package controller.listener;

import model.SavedGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Listener for the save game button.
 */
public class SaveGameButtonListener extends GameListener {

    /**
     * The frame holding the Select button.
     */
    private final JFrame myFrame;

    public SaveGameButtonListener(final JFrame theFrame) {
        super();
        myFrame = theFrame;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        final JButton buttonClicked = (JButton) e.getSource();
        final var text = buttonClicked.getText();
        String save;
        switch (text) {
            case "Save 1" -> save = "src/resources/saved_games/Save1.ser";
            case "Save 2" -> save = "src/resources/saved_games/Save2.ser";
            case "Save 3" -> save = "src/resources/saved_games/Save3.ser";
            default -> {
                save = "src/resources/saved_games/SaveError.ser";
                System.err.println("Text in Save buttons was changed. -> SaveGameButtonListener");
            }
        }


        SavedGame beingSaved = new SavedGame();
        beingSaved.setMyMap(getEnvironmentManager().getMyMap());
        beingSaved.setMyUserRow(getEnvironmentManager().getMyUserRow());
        beingSaved.setMyUserCol(getEnvironmentManager().getMyUserCol());
        beingSaved.setMyUserLives(getEnvironmentManager().getPlayerLives());
        beingSaved.setInChildMode(getEnvironmentManager().getInChildMode());

        // Serialization
        try {

            final FileOutputStream fileOut = new FileOutputStream(save);
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(beingSaved);
            out.close();

            fileOut.close();


        } catch (final IOException ex) {
            ex.printStackTrace();
        }

        // close container frame
        myFrame.dispose();
    }
}
