package view;

import controller.listener.menupanel.*;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Designs the Menu Panel for the game.
 * The menu panel consists of buttons that perform
 * actions related to the game, such as, Menu, Load
 * Save, and Help
 * @author Sean, Robert
 * @version 1
 */
public final class MenuPanel extends JPanel {

    /**
     * Singleton Style Unique Instance.
     */
    private static MenuPanel UNIQUE_INSTANCE;

    /**
     * Constructor for Menu Panel
     */
    private MenuPanel() {
        buildMenuButtons();
        setUpPanel();
    }

    /**
     * Get Instance Method
     * @return uniqueInstance
     */
    public static MenuPanel getInstance() {
        if (UNIQUE_INSTANCE == null) {
            UNIQUE_INSTANCE = new MenuPanel();
        }
        return UNIQUE_INSTANCE;
    }

    /**
     * Builds ArrayList of Buttons
     */
    private final ArrayList<JButton> myMenu = new ArrayList<>();

    /**
     * Gets Menu Button (index zero)
     * @return Menu Button
     */
    public JButton getMenuButton() {
        return myMenu.get(0);
    }

    /**
     * gets New Game Button (index 1)
     * @return New Game Button
     */
    public JButton getNewGameButton() {
        return myMenu.get(1);
    }

    /**
     * Gets Save Button (index 2)
     * @return Save Button
     */
    public JButton getSaveButton() {
        return myMenu.get(2);
    }

    /**
     * Gets Load Button (index 3)
     * @return Load Button
     */
    public JButton getLoadButton() {
        return myMenu.get(3);
    }

    /**
     * Gets Help Button (index 4)
     * @return Help Button
     */
    public JButton getHelpButton() {
        return myMenu.get(4);
    }

    /**
     * Sets up and adds elements to the panel.
     */
    private void setUpPanel() {
        // Set Up Panel
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE,2, true));

        // Add components
        add(getMenuButton());
        add(getNewGameButton());
        add(getSaveButton());
        add(getLoadButton());
        add(getHelpButton());
    }

    /**
     * Builds the Buttons for the Menu Panel
     */
    private void buildMenuButtons() {
        //Create and add "Menu" Button
        final var menuButton = new JButton();
        menuButton.setText("Menu");
        menuButton.addActionListener(new MenuButtonListener());
        myMenu.add(menuButton);

        // New Game Button
        final var newGameButton = new JButton();
        newGameButton.setText("New Game");
        newGameButton.addActionListener(new NewGameButtonListener());
        myMenu.add(newGameButton);

        //Create and add "Save" Button
        final var saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new SaveOptionListener());
        myMenu.add(saveButton);

        //Create and add "Load" Button
        final var loadButton = new JButton();
        loadButton.setText("Load");
        loadButton.addActionListener(new LoadOptionListener());
        myMenu.add(loadButton);

        //Create and add "Help" Button
        final var helpButton = new JButton();
        helpButton.setText("Help");
        helpButton.addActionListener(new HelpButtonListener());
        myMenu.add(helpButton);
    }

    /**
     * Displays the option to select which content version of the game will be played.
     * Child Content is defaulted.
     */
    public void displayMenuButtonOptions() {
        final var contentFrame = new JFrame("Content Selector");
        contentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentFrame.setLayout(new FlowLayout());
        contentFrame.setSize(PaneConst.CONTENT_SELECTOR_SIZE.value(), PaneConst.CONTENT_SELECTOR_SIZE.value());
        contentFrame.setLocationRelativeTo(Environment.getInstance());
        contentFrame.setResizable(false);

        final var adultContent = new JRadioButton("Adult Content");
        final var childContent = new JRadioButton("Child Content");
        childContent.setSelected(true);

        final var group = new ButtonGroup();
        group.add(adultContent);
        group.add(childContent);

        final var okayButton = new JButton("Select");
        okayButton.addActionListener(new ContentSelectListener(childContent, contentFrame));

        contentFrame.add(adultContent);
        contentFrame.add(childContent);
        contentFrame.add(okayButton);

        contentFrame.setVisible(true);
        contentFrame.pack();
    }

    /**
     * Displays the help portion of the program.
     */
    public void displayHelp() {

        final var helpFrame = new JFrame("Help");
        helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpFrame.setLayout(new FlowLayout());
        helpFrame.setSize(PaneConst.HELP_WIDTH.value(), PaneConst.HELP_HEIGHT.value());
        helpFrame.setLocationRelativeTo(Environment.getInstance());
        helpFrame.setResizable(false);

        final var textArea = new JTextArea();
        textArea.setMargin(new Insets(5, 15, 15, 15));
        textArea.setSize(PaneConst.HELP_WIDTH.value(), PaneConst.HELP_HEIGHT.value());
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        textArea.setText("\t        Menu Bar Options\n- Selecting \"Menu\" will allow you to choose to play the game in either " +
                "Adult Content Mode or Child Mode.\n- Selecting \"New Game\" will allow you to start the game over, erasing" +
                "the contents of the current game.\n- Selecting \"Save\" once you are playing a game will save the current" +
                "state of your game.\n- Selecting \"Load\" will allow you to load a previously saved game to play.\n" +
                "- Selecting \"Help\"....well you've discovered that already.\n\n\t        Playing the Game\n- The Game objective " +
                "is to make it to the portal and escape!\n- To move Pickle Rick around you can use the arrow buttons on the bottom " +
                "left panel, he will move the direction you wish as long as you are trying to move on the path.\n- The black walls on the maze are " +
                "barriers you cannot pass.\n- The move-able path is teal-ish.\n- As you enter a door you will be prompted a question, " +
                "if you get this question wrong the door will be locked for good and you will lose a life.\n- If you get the question right the door will " +
                "disappear and you can continue.\n- You have a total of 3 lives. Pickle Rick currently has one life displayed " +
                "(him on the map), if you get a question wrong he will take a life from the lives displayed in the bottom left. " +
                "Once you have lost all 3 lives you lose the game.\n- You can also lose the game by running out of questions, so be careful" +
                "with how many times you select a new question\n- Questions will be displayed in the bottom right corner of the game." +
                " Simply choose option \"A,B,C,D\" for the correct answer.\n\n\n\n\n");


        helpFrame.add(textArea);
        helpFrame.setVisible(true);
    }

    /**
     * Displays the option to save the game to various slots.
     */
    public void displaySaveGameOptions() {
        final var saveGameFrame = new JFrame("Save Game Options");
        saveGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        saveGameFrame.setLayout(new FlowLayout());
        saveGameFrame.setSize(PaneConst.CONTENT_SELECTOR_SIZE.value(), PaneConst.CONTENT_SELECTOR_SIZE.value());
        saveGameFrame.setLocationRelativeTo(Environment.getInstance());
        saveGameFrame.setResizable(false);

        final var saveOne = new JButton("Save 1");
        saveOne.addActionListener(new SaveGameButtonListener(saveGameFrame));
        final var saveTwo = new JButton("Save 2");
        saveTwo.addActionListener(new SaveGameButtonListener(saveGameFrame));
        final var saveThree = new JButton("Save 3");
        saveThree.addActionListener(new SaveGameButtonListener(saveGameFrame));

        saveGameFrame.add(saveOne);
        saveGameFrame.add(saveTwo);
        saveGameFrame.add(saveThree);

        saveGameFrame.setVisible(true);
        saveGameFrame.pack();
    }

    /**
     * Displays the option to load the game to various slots.
     */
    public void displayLoadGameOptions() {
        final var loadGameFrame = new JFrame("Load Game Options");
        loadGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loadGameFrame.setLayout(new FlowLayout());
        loadGameFrame.setSize(PaneConst.CONTENT_SELECTOR_SIZE.value(), PaneConst.CONTENT_SELECTOR_SIZE.value());
        loadGameFrame.setLocationRelativeTo(Environment.getInstance());
        loadGameFrame.setResizable(false);

        final var loadOne = new JButton("Load 1");
        loadOne.addActionListener(new LoadButtonListener(loadGameFrame));
        final var loadTwo = new JButton("Load 2");
        loadTwo.addActionListener(new LoadButtonListener(loadGameFrame));
        final var loadThree = new JButton("Load 3");
        loadThree.addActionListener(new LoadButtonListener(loadGameFrame));

        loadGameFrame.add(loadOne);
        loadGameFrame.add(loadTwo);
        loadGameFrame.add(loadThree);

        loadGameFrame.setVisible(true);
        loadGameFrame.pack();
    }
}