package view;

import controller.EnvironmentManager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;

/** Environment for where the background will initially
 * be displayed. After a game is selected, Environment
 * will be used as the game playing field.
 * @author Robert
 * @version 1
 */
public final class Environment extends JPanel {

    /**
     * Singleton Style Unique Instance.
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
        final ImageIcon environmentBackground = new ImageIcon("src/resources/Images/RickAndMortyBreakingBad.png");
        final JLabel background = new JLabel();
        background.setBounds(0, 0, PaneConst.WINDOW_WIDTH.value(), PaneConst.ENVIRONMENT_HEIGHT.value());
        background.setIcon(environmentBackground);
        setLayout(null);
        add(background);
    }

    /**
     * Changes Environment panel when the game is one.
     */
    public void gameWonEnvironmentPanel() {
        EnvironmentManager.getInstance().emptyCurrentEnvironment();
        final ImageIcon winningEnvironmentBackground = new ImageIcon("src/resources/Images/RickAndMortyDancing.gif");
        final JLabel winningBackground = new JLabel();
        winningBackground.setBounds(0, 0, PaneConst.WINDOW_WIDTH.value(), PaneConst.WINDOW_HEIGHT.value());
        winningBackground.setBackground(Color.BLACK);
        winningBackground.setIcon(winningEnvironmentBackground);
        setLayout(null);
        add(winningBackground);
    }

}