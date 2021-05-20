package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles Actions related to the New Game button.
 * @author Robert
 * @version 1
 */
public class NewGameButtonListener implements ActionListener {

    private final EnvironmentGenerator environmentGenerator;

    public NewGameButtonListener() {
        environmentGenerator = new EnvironmentGenerator();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        environmentGenerator.generateNewEnvironment();
    }
}
