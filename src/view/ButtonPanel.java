package view;

import controller.listener.DownButtonListener;
import controller.listener.LeftButtonListener;
import controller.listener.RightButtonListener;
import controller.listener.UpButtonListener;
import model.CellType;
import model.GameObject;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

/**
 * Singleton style class that builds the control buttons container.
 * @author Robert
 * @version 1
 */
public final class ButtonPanel extends JPanel {

    /**
     * Unique instance of the panel.
     */
    private static ButtonPanel UNIQUE_INSTANCE;

    /**
     * Horizontal adjustment for Arrow button placement.
     */
    private final int ARROW_HORIZONTAL_ADJ = 95;

    /**
     * Array for internal storage of actual arrow buttons.
     */
    private final JButton[] myArrows = new JButton[4];

    /**
     * Holds the graphical representation of lives for player.
     */
    private final GameObject[] myLives = new GameObject[3];

    /**
     * Singleton constructor.
     */
    private ButtonPanel() {
        buildButtonPanel();
    }

    /**
     * Gets unique instance of the button panel.
     * @return only instance of the ButtonPanel.
     */
    public static ButtonPanel getInstance() {
        if(UNIQUE_INSTANCE == null) {
            UNIQUE_INSTANCE = new ButtonPanel();
        }
        return UNIQUE_INSTANCE;
    }

    /**
     * Gets up JButton.
     * @return up button.
     */
    public JButton getUpButton() {
        return myArrows[0];
    }

    /**
     * Gets right JButton.
     * @return right button.
     */
    public JButton getRightButton() {
        return myArrows[1];
    }

    /**
     * Gets down JButton.
     * @return down button.
     */
    public JButton getDownButton() {
        return myArrows[2];
    }

    /**
     * Gets left JButton.
     * @return left button.
     */
    public JButton getLeftButton() {
        return myArrows[3];
    }


    /**
     * Adds three lives for the user to use for the game, handles graphics only not actual life count.
     */
    public void addUserLives(final int theLives) {
        // Checks to see if any need to be removed before adding proper amount of lives.
        if (theLives == 2 || theLives == 1) {
            remove(myLives[0]);
            remove(myLives[1]);
            remove(myLives[2]);
            repaint();
        }
        final var width = CellType.LIFE.getCellWidth();
        var RICK_LIFE_HORIZONTAL_ADJ = 5;
        final var RICK_LIFE_VERTICAL_ADJ = 20;

        for(int i = 0; i < theLives; i++) {
            myLives[i].setBounds(RICK_LIFE_HORIZONTAL_ADJ, RICK_LIFE_VERTICAL_ADJ, width, CellType.LIFE.getCellHeight());
            add(myLives[i]);

            RICK_LIFE_HORIZONTAL_ADJ += width;
        }

        repaint();
    }

    /**
     * Removes graphical representation of life.
     * @param theLifeIndex that the user has lost.
     */
    public void removeLifeCell(final int theLifeIndex) {
        remove(myLives[theLifeIndex]);
        repaint();
    }


    /**
     * Used to disable buttons when not needed.
     */
    public void disableArrowButtons() {
        for (JButton myArrow : myArrows) {
            myArrow.setEnabled(false);
        }
    }


    /**
     * Consolidation of all the sub methods that build the individual components that belong in the ButtonPanel.
     */
    private void buildButtonPanel() {
        instantiateButtons();
        instantiateLives();
        setPanelsState();
        buildUpButton();
        buildRightButton();
        buildDownButton();
        buildLeftButton();
        addButtons();
    }


    /**
     * Instantiates the arrow button with the array.
     */
    private void instantiateButtons() {
        for(int i = 0; i < myArrows.length; i++) {
            myArrows[i] = new JButton();
        }
    }


    /**
     * Instantiates graphical representation of user lives.
     */
    private void instantiateLives() {
        for(int i = 0; i < myLives.length; i++) {
            myLives[i] = GameObject.assignGameObject(CellType.LIFE.getID());
        }
    }


    /**
     * Customize ButtonPanel.
     */
    private void setPanelsState() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2, true));
    }

    /**
     * Builds and customizes the up arrow button.
     */
    private void buildUpButton() {
        final var up = getUpButton();
        final var panelWidth = PaneConst.WINDOW_WIDTH.value() / 2;
        final var buttonSize = PaneConst.ARROW_SIZE.value();
        final var upArrowIcon = new ImageIcon("src/resources/Images/Up Arrow.png");
        final var upArrowLabel = new JLabel(upArrowIcon);

        up.setBackground(Color.LIGHT_GRAY);
        up.addActionListener(new UpButtonListener());
        up.add(upArrowLabel);
        up.setBounds(panelWidth / 2 - buttonSize / 2 + ARROW_HORIZONTAL_ADJ, 2, buttonSize, buttonSize);
        up.setEnabled(false);
    }

    /**
    Builds and customizes the right arrow button.
    */
    private void buildRightButton() {
        final var right = getRightButton();
        final var panelWidth = PaneConst.WINDOW_WIDTH.value() / 2;
        final var panelHeight = PaneConst.SOUTH_HEIGHT.value();
        final var buttonSize = PaneConst.ARROW_SIZE.value();
        final var rightArrowIcon = new ImageIcon("src/resources/Images/Right Arrow.png");
        final var rightArrowLabel = new JLabel(rightArrowIcon);

        right.setBackground(Color.LIGHT_GRAY);
        right.addActionListener(new RightButtonListener());
        right.add(rightArrowLabel);
        right.setBounds(panelWidth / 2 + buttonSize / 2 + ARROW_HORIZONTAL_ADJ, panelHeight / 2 - buttonSize / 2, buttonSize, buttonSize);
        right.setEnabled(false);
    }

    /**
    Builds and customizes the down arrow button.
     */
    private void buildDownButton() {
        final var down = getDownButton();
        final var panelWidth = PaneConst.WINDOW_WIDTH.value() / 2;
        final var panelHeight = PaneConst.SOUTH_HEIGHT.value();
        final var buttonSize = PaneConst.ARROW_SIZE.value();
        final var downArrowIcon = new ImageIcon("src/resources/Images/Down Arrow.png");
        final var downArrowLabel = new JLabel(downArrowIcon);

        down.setBackground(Color.LIGHT_GRAY);
        down.addActionListener(new DownButtonListener());
        down.add(downArrowLabel);
        down.setBounds(panelWidth / 2 - buttonSize / 2 + ARROW_HORIZONTAL_ADJ, 66 * panelHeight / 100, buttonSize, buttonSize);
        down.setEnabled(false);
    }

    /**
    Builds and customizes left arrow button.
     */
    private void buildLeftButton() {
        final var left = getLeftButton();
        final var panelWidth = PaneConst.WINDOW_WIDTH.value() / 2;
        final var panelHeight = PaneConst.SOUTH_HEIGHT.value();
        final var buttonSize = PaneConst.ARROW_SIZE.value();
        final var leftArrowIcon = new ImageIcon("src/resources/Images/Left Arrow.png");
        final var leftArrowLabel = new JLabel(leftArrowIcon);

        left.setBackground(Color.LIGHT_GRAY);
        left.addActionListener(new LeftButtonListener());
        left.add(leftArrowLabel);
        left.setBounds(panelWidth / 2 - buttonSize / 2 - buttonSize + ARROW_HORIZONTAL_ADJ, panelHeight / 2 - buttonSize / 2, buttonSize, buttonSize);
        left.setEnabled(false);
    }

    /**
     * Adds buttons to panel.
     */
    private void addButtons() {
        add(getUpButton());
        add(getRightButton());
        add(getDownButton());
        add(getLeftButton());
    }

}