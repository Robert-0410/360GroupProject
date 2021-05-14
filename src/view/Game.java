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
    private static Game uniqueInstance;

    /**
     * ArrayList of all the panels composing game panel.
     */
    private ArrayList<GUIPanel> myPanels;

    /**
     * Singleton style constructor.
     */
    private Game() {
        buildGame();
    }

    /**
     * Getter for single instance of Game.
     * @return unique instance of Game.
     */
    public static Game getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Game();
        }
        return uniqueInstance;
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
        var menuPanel = MenuPanel.getInstance();
        myPanels.add(0, menuPanel);
        var buttonPanel = ButtonPanel.getInstance();
        myPanels.add(2, buttonPanel);
    }

    /**
     * Prepares the main panel holding the rest of the unique panels.
     */
    private void prepGamePanel() {
        setLayout(new BorderLayout());
    }

    /**
     * Adds unique panels to the main panel.
     */
    private void addPanels() {
        add(myPanels.get(0), BorderLayout.NORTH);
        add(myPanels.get(2), BorderLayout.SOUTH);
    }
}
