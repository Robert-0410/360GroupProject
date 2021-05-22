package controller;

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
        getEnvironmentGenerator().generateInitialEnvironment();
    }
}
