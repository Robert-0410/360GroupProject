package controller;

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
    private final EnvironmentGenerator environmentGenerator;

    /**
     * Connects unique instance of the environmentGenerator.
     */
    protected GameListener() {
        environmentGenerator = EnvironmentGenerator.getInstance();
    }

    /**
     * Gets the unique instance of the EnvironmentGenerator.
     * @return EnvironmentGenerator
     */
    protected EnvironmentGenerator getEnvironmentGenerator() {
        return environmentGenerator;
    }
}
