package view;

import javax.swing.*;

/** Environment for where the background will initially
  * be displayed. After a game is selected, Environment
  * will be used as the game playing field.
  */
public class Environment extends JPanel {

    /** Singleton Style Unique Instance.
    */
    private static Environment UNIQUE_INSTANCE;

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
        ImageIcon environmentBackground = new ImageIcon("src/resources/RickAndMortyBreakingBad.png");
        JLabel background = new JLabel();
        background.setIcon(environmentBackground);
        //add(background);
    }

}