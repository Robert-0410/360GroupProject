package view;

import javax.swing.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel {
    private static MenuPanel uniqueInstance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MenuPanel();
            // TODO: call builder method
        }
        return uniqueInstance;
    }

    /**
     * Builds ArrayList of Buttons
     */
    private ArrayList<JButton> myMenu = new ArrayList<>();

    /**
     * Gets Menu Button (index zero)
     * @return Menu Button
     */
    public JButton getMenuButton() {
        return myMenu.get(0);
    }

    /**
     * Gets Save Button (index one)
     * @return Save Button
     */
    public JButton getSaveButton() {
        return myMenu.get(1);
    }

    /**
     * Gets Load Button (index two)
     * @return Load Button
     */
    public JButton getLoadButton() {
        return myMenu.get(2);
    }

    /**
     * Gets Help Button (index 3)
     * @return Help Button
     */
    public JButton getHelpButton() {
        return myMenu.get(3);
    }

    public void buildMenuButtons() {
        //In here set placements for buttons
        //Create and add "Menu" Button
        JButton myMenuButton = new JButton();
        myMenu.add(myMenuButton);

        JButton mySaveButton = new JButton();
        myMenu.add(mySaveButton);
    }
}
