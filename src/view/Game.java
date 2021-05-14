package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *  Holds all panels that display the trivia game.
 */
public class Game extends JPanel {

    /**
     * Singleton style class.
     */
    private static Game UNIQUE_INSTANCE;
    /**
     * Initial width of window.
     */
    private static final int WINDOW_WIDTH = 900;

    /**
     * Initial height of window.
     */
    private static final int WINDOW_HEIGHT = 650;

    /**
     * ArrayList of all the panels composing game panel.
     */
    private ArrayList<GUIPanel> myPanels;

    /**
     * Singleton style constructor.
     */
    private Game() {
        super();
        buildGame();
    }

    /**
     * Getter for single instance of Game.
     * @return unique instance of Game.
     */
    public static Game getInstance() {
        if(UNIQUE_INSTANCE == null) {
            UNIQUE_INSTANCE = new Game();
        }
        return UNIQUE_INSTANCE;
    }

    /**
     * Triggers the GUI to display.
     */
    public void display() {
        final JFrame frame = new JFrame("Whats the name!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this); // This adds panel to the frame.

        frame.pack();

        //We need to pick a frame size
        frame.setSize(750, 750);

        //I think we should make in non resizable
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    /**
     * Consolidates methods that build the GUI.
     */
    private void buildGame() {
        fetchPanels();
        prepGamePanel();
        addPanels();
    }

    /**
     * Retrieves unique instances of panels and adds them to myPanels.
     */
    private void fetchPanels() {
        myPanels = new ArrayList<>(4);

        var menuPanel = MenuPanel.getInstance();
        myPanels.add(menuPanel);

        var environmentPanel = Environment.getInstance();
        myPanels.add(environmentPanel);

        var buttonPanel = ButtonPanel.getInstance();
        myPanels.add(buttonPanel);
    }

    /**
     * Prepares the main panel holding the rest of the unique panels.
     */
    private void prepGamePanel() {
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLayout(new BorderLayout());
    }

    /**
     * Adds unique panels to the main panel.
     */
    private void addPanels() {
        add(myPanels.get(0), BorderLayout.NORTH);
        add(myPanels.get(1), BorderLayout.CENTER);
        add(myPanels.get(2), BorderLayout.SOUTH);
    }
}
