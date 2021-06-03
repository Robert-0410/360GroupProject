package controller.listener;

import model.SavedGame;

import java.awt.event.ActionEvent;

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

        SavedGame test = new SavedGame();
        test.setMyMap(getEnvironmentManager().getMyMap());
        test.setMyUserRow(getEnvironmentManager().getMyUserRow());
        test.setMyUserRow(getEnvironmentManager().getMyUserCol());
        test.setMyUserLives(getEnvironmentManager().getPlayerLives());
        test.setInChildMode(getEnvironmentManager().getInChildMode());
        test.checkObject();

    }
}
