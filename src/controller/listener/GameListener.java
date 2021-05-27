package controller.listener;

import controller.EnvironmentManager;

import java.awt.event.ActionListener;

/**
 * Abstract class representing a basic listener for the game.
 * @author Robert
 * @version 1
 */
public abstract class GameListener implements ActionListener {

    /**
     * Unique instance of of the EnvironmentGenerator.
     */
    private final EnvironmentManager environmentManager;

    /**
     * Connects unique instance of the environmentGenerator.
     */
    protected GameListener() {
        environmentManager = EnvironmentManager.getInstance();
    }

    /**
     * Gets the unique instance of the EnvironmentGenerator.
     * @return EnvironmentGenerator
     */
    protected EnvironmentManager getEnvironmentGenerator() {
        return environmentManager;
    }
}
