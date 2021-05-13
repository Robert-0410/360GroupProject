package view;

import javax.swing.*;

public class ButtonPanel extends JPanel {

    // TODO add to UML
    private static ButtonPanel uniqueInstance;

    private final JButton[] myArrows= new JButton[4];

    /**
     * Singleton constructor.
     */
    private ButtonPanel() {
        buildButtonPanel();
    }

    // TODO add to UML
    public static ButtonPanel getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new ButtonPanel();
        }
        return uniqueInstance;
    }


    // getters
    // TODO: update UML for all getters for each button
    public JButton getUpButton() {
        return myArrows[0];
    }

    public JButton getRightButton() {
        return myArrows[1];
    }

    public JButton getDownButton() {
        return myArrows[2];
    }

    public JButton getLeftButton() {
        return myArrows[3];
    }
    // buildButtonPanel() {you need all your methods that build your panel}
    private void buildButtonPanel() {
        instantiateButtons();
        buildUpButton();
        buildRightButton();
        buildDownButton();
        buildLeftButton();
    }
    private void instantiateButtons() {
        for(int i = 0; i < myArrows.length; i++) {
            myArrows[i] = new JButton();
        }
    }

    private void buildUpButton() {
        var up = getUpButton();
        up.setText("Up");
    }

    private void buildRightButton() {
        var right = getRightButton();
        right.setText("Right");
    }

    private void buildDownButton() {
        var down = getDownButton();
        down.setText("Down");
    }

    private void buildLeftButton() {
        var left = getLeftButton();
    }
    // buildArrowButtons() {handle all creation of arrows}

}
