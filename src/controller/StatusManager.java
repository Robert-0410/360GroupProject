package controller;

import view.ButtonPanel;
import view.MenuPanel;


/**
 * Utility for status control of all game components.
 * @author Robert
 * @version 1
 */
public class StatusManager {

    /**
     * Not to be invoked.
     */
    private StatusManager() {}

    /**
     * Enables buttons to start playing as Rick.
     */
    protected static void enableGameButtons() {
        var currentPanel = MenuPanel.getInstance();
        // Menu Panel
        currentPanel.getSaveButton().setEnabled(true);

        // Button Panel
        enableMovementButtons();
    }


    /**
     * Enables arrow buttons that allow users to move in the environment.
     */
    private static void enableMovementButtons() {
        var currentPanel = ButtonPanel.getInstance();
        currentPanel.getUpButton().setEnabled(true);
        currentPanel.getRightButton().setEnabled(true);
        currentPanel.getDownButton().setEnabled(true);
        currentPanel.getLeftButton().setEnabled(true);
    }

}