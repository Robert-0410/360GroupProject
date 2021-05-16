package view;

import javax.swing.*;
import java.awt.*;

/** Environment for where the background will initially
  * be displayed. After a game is selected, Environment
  * will be used as the game playing field.
  */
public class Environment extends GUIPanel {
    /** Singleton Style Unique Instance.
    */
    private static Environment UNIQUE_INSTANCE;

    /**
     * Initial width of window.
     */
    private static final int PANEL_WIDTH = 900;

    /**
     * Initial height of window.
     */
    private static final int PANEL_HEIGHT = 650;

    /**
     * Constructor for Environment Class.
     */
    private Environment() {
        setUpEnvironmentPanel();
    }

    /**
     * Get Instance Method
     * @return uniqueInstance
     */
    public static Environment getInstance() {
        if (UNIQUE_INSTANCE == null) {
            UNIQUE_INSTANCE = new Environment();
        }
        return UNIQUE_INSTANCE;
    }

    /**
     * Sets up the Environment panel
     */
    private void setUpEnvironmentPanel() {
        setBounds(0,0,PANEL_WIDTH, PANEL_HEIGHT);
        ImageIcon environmentBackground = new ImageIcon("src/resources/RickAndMortyBreakingBad.png");
        JLabel background = new JLabel();
        background.setIcon(environmentBackground);
        add(background);
    }

}