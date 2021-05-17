package view;

import controller.EnvironmentGenerator;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
     * TODO UML
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
        final JFrame frame = new JFrame("Whats the name!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this); // This adds panel to the frame.

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // For quick painting of a single cell for testing.
        var engGen = new EnvironmentGenerator();
        //myPanels.get(1).add(engGen.test);

        frame.setVisible(true);

        // TODO Temp: used for painting single GameObject.

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

        var menuPanel = MenuPanel.getInstance();
        myPanels.add(menuPanel);

        var environmentPanel = Environment.getInstance();
        myPanels.add(environmentPanel);

        var buttonPanel = ButtonPanel.getInstance();
        myPanels.add(buttonPanel);

        var questionPanel = QuestionPanel.getInstance();
        myPanels.add(questionPanel);
    }

    /**
     * Prepares the main panel holding the rest of the unique panels.
     */
    private void prepMainPanel() {
        setPreferredSize(new Dimension(PaneConst.WINDOW_WIDTH.value(), PaneConst.WINDOW_HEIGHT.value()));
        setLayout(new BorderLayout());
    }

    /**
     * Prepares the panel located on the SOUTH, holds ButtonPanel & QuestionPanel.
     * TODO UML
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
