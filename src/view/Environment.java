package view;

import javax.swing.*;

/**
 * Environment for where the background will initially
 * be displayed. After a game is selected, Environment
 * will be used as the game playing field.
 */
public class Environment extends GUIPanel {
    /**
     * Singleton Style Unique Instance.
     */
    private static Environment uniqueInstance;

    /**
     * Constructor for Environment Class
     */
    private Environment() {
        setUpEnvironmentPanel();
    }

    /**
     * Get Instance Method
     * @return uniqueInstance
     */
    public static Environment getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Environment();
        }
        return uniqueInstance;
    }

    /**
     * Sets up the Environment panel
     */
    private void setUpEnvironmentPanel() {
        setSize(750, 500);
        JLabel environmentBackground = new JLabel(new ImageIcon("src/resources/RickAndMortyBackground.jpg"));
        environmentBackground.setSize(750, 500);
        add(environmentBackground);
    }

}