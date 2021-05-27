package controller.listener;

import controller.StatusManager;
import view.ButtonPanel;
import java.awt.event.ActionEvent;

/**
 * Handles Actions related to the New Game button.
 * @author Robert
 * @version 1
 */
public class NewGameButtonListener extends GameListener {

    /**
     * For the NewGameButton.
     */
    public NewGameButtonListener() {
        super();
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        StatusManager.enableGameButtons();
        getEnvironmentGenerator().getMyMap().clear();
        getEnvironmentGenerator().resetPlayerLocation();
        getEnvironmentGenerator().generateInitialEnvironment();
        ButtonPanel.getInstance().addUserLives();
        getEnvironmentGenerator().resetPlayerLives();
    }
}
