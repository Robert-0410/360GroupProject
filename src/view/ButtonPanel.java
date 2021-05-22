package view;

import controller.DownButtonListener;
import controller.RightButtonListener;

import javax.swing.*;
import java.awt.Color;

/**
 * Singleton style class that builds the control buttons container.
 * @author Robert
 * @version 1
 */
public class ButtonPanel extends JPanel {

    /**
     * Unique instance of the panel.
     */
    private static ButtonPanel UNIQUE_INSTANCE;

    /**
     * Array for internal storage of actual arrow buttons.
     */
    private final JButton[] myArrows= new JButton[4];

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
    Consolidation of all the sub methods that build the individual components that belong in the ButtonPanel.
     */
    private void buildButtonPanel() {
        instantiateButtons();
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
     * Customize ButtonPanel.
     * TODO UML
     */
    private void setPanelsState() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2, true));
    }

    /**
    Builds and customizes the up arrow button.
     */
    private void buildUpButton() {
        var up = getUpButton();
        var panelWidth = PaneConst.WINDOW_WIDTH.value() / 2;
        var buttonSize = PaneConst.ARROW_SIZE.value();

        up.setText("Up");
        up.setBounds(panelWidth / 2 - buttonSize / 2, 8, buttonSize, buttonSize);
    }

    /**
    Builds and customizes the right arrow button.
    */
    private void buildRightButton() {
        var right = getRightButton();
        var panelWidth = PaneConst.WINDOW_WIDTH.value() / 2;
        var panelHeight = PaneConst.SOUTH_HEIGHT.value();
        var buttonSize = PaneConst.ARROW_SIZE.value();

        right.addActionListener(new RightButtonListener());
        right.setText("Right");
        right.setBounds(panelWidth / 2 + buttonSize / 2, panelHeight / 2 - buttonSize / 2, buttonSize, buttonSize);
    }

    /**
    Builds and customizes the down arrow button.
     */
    private void buildDownButton() {
        var down = getDownButton();
        var panelWidth = PaneConst.WINDOW_WIDTH.value() / 2;
        var panelHeight = PaneConst.SOUTH_HEIGHT.value();
        var buttonSize = PaneConst.ARROW_SIZE.value();

        down.addActionListener(new DownButtonListener());
        down.setText("Down");
        down.setBounds(panelWidth / 2 - buttonSize / 2, 66 * panelHeight / 100, buttonSize, buttonSize);
    }

    /**
    Builds and customizes left arrow button.
     */
    private void buildLeftButton() {
        var left = getLeftButton();
        var panelWidth = PaneConst.WINDOW_WIDTH.value() / 2;
        var panelHeight = PaneConst.SOUTH_HEIGHT.value();
        var buttonSize = PaneConst.ARROW_SIZE.value();

        left.setText("Left");
        left.setBounds(panelWidth / 2 - buttonSize / 2 - buttonSize, panelHeight / 2 - buttonSize / 2, buttonSize, buttonSize);
    }

    /**
     * Adds buttons to panel.
     * TODO UML
     */
    private void addButtons() {
        add(getUpButton());
        add(getRightButton());
        add(getDownButton());
        add(getLeftButton());
    }

}