package view;

import javax.swing.*;

/**
 * Singleton style class that builds the control buttons container.
 */
public class ButtonPanel extends JPanel {

    // TODO add to UML
    /**
     * Unique instance of the panel.
     */
    private static ButtonPanel uniqueInstance;

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

    // TODO add to UML

    /**
     * Gets unique instance of the button panel.
     * @return only instance of the ButtonPanel.
     */
    public static ButtonPanel getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new ButtonPanel();
        }
        return uniqueInstance;
    }


    // TODO: update UML for all getters for each button

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
        buildUpButton();
        buildRightButton();
        buildDownButton();
        buildLeftButton();
    }

    /**
    Instantiates the arrow button with the array.
     */
    private void instantiateButtons() {
        for(int i = 0; i < myArrows.length; i++) {
            myArrows[i] = new JButton();
        }
    }

    /**
    Builds and customizes the up arrow button.
     */
    private void buildUpButton() {
        var up = getUpButton();
        up.setText("Up");
    }

    /**
    Builds and customizes the right arrow button.
    */
    private void buildRightButton() {
        var right = getRightButton();
        right.setText("Right");
    }

    /**
    Builds and customizes the down arrow button.
     */
    private void buildDownButton() {
        var down = getDownButton();
        down.setText("Down");
    }

    /**
    Builds and customizes left arrow button.
     */
    private void buildLeftButton() {
        var left = getLeftButton();
        left.setText("Left");
    }


}
