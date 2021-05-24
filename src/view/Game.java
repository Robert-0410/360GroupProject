package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *  Holds all panels that display the trivia game.
 * @author Robert
 * @version 1
 */
public class Game extends JPanel {

    /**
     * Singleton style class.
     */
    private static Game UNIQUE_INSTANCE;

    /**
     * ArrayList of all the panels composing game panel.
     * 0 - MenuPanel
     * 1 - Environment
     * 2 - ButtonPanel
     * 3 - QuestionPanel
     */
    private ArrayList<JPanel> myPanels;

    /**
     * Holds ButtonPanel and the QuestionPanel on the SOUTH part of the main panel.
     */
    private JPanel mySouthPanel;

    /**
     * Singleton style constructor.
     */
    private Game() {
        super();
        buildMainPanel();
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
        final JFrame frame = new JFrame("Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this); // This adds panel to the frame.

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    /**
     * Consolidates methods that build the GUI.
     */
    private void buildMainPanel() {
        fetchPanels();
        prepMainPanel();
        addPanels();
    }

    /**
     * Retrieves unique instances of panels and adds them to myPanels.
     */
    private void fetchPanels() {
        myPanels = new ArrayList<>(4);

        myPanels.add(MenuPanel.getInstance());
        myPanels.add(Environment.getInstance());
        myPanels.add(ButtonPanel.getInstance());
        myPanels.add(QuestionPanel.getInstance());

    }

    /**
     * Prepares the main panel holding all the unique panels.
     */
    private void prepMainPanel() {
        setPreferredSize(new Dimension(PaneConst.WINDOW_WIDTH.value(), PaneConst.WINDOW_HEIGHT.value()));
        setLayout(new BorderLayout());
    }

    /**
     * Prepares the panel located on the SOUTH, holds ButtonPanel & QuestionPanel.
     */
    private void prepSouthPanel() {
        mySouthPanel = new JPanel();
        mySouthPanel.setPreferredSize(new Dimension(PaneConst.WINDOW_WIDTH.value(), PaneConst.SOUTH_HEIGHT.value()));
        mySouthPanel.setLayout(new GridLayout(1, 2));

        mySouthPanel.add(myPanels.get(2));
        mySouthPanel.add(myPanels.get(3));
    }

    /**
     * Adds unique panels to the main panel.
     */
    private void addPanels() {
        add(myPanels.get(0), BorderLayout.NORTH);
        add(myPanels.get(1), BorderLayout.CENTER);

        prepSouthPanel();
        add(mySouthPanel, BorderLayout.SOUTH);
    }

}
