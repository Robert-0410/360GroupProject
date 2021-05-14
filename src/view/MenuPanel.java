package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Designs the Menu Panel for the game.
 * The menu panel consists of buttons that perform
 * actions related to the game, such as, Menu, Load
 * Save, and Help.
 */
public class MenuPanel extends JPanel {
    private static MenuPanel uniqueInstance;

    private MenuPanel() {
        buildMenuButtons();
        setUpPanel();
    }

    /**
     * Get Instance Method
     * @return uniqueInstance
     */
    public static MenuPanel getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MenuPanel();
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

    /**
     * Sets up and adds elements to the panel.
     */
    private void setUpPanel() {
        // Set Up Panel
        setSize(750, 100);
        add(getMenuButton());
        add(getSaveButton());
        add(getLoadButton());
        add(getHelpButton());
    }

    /**
     * Builds the Buttons for the Menu Panel
     */
    private void buildMenuButtons() {
        //Create and add "Menu" Button
        JButton myMenuButton = new JButton();
        myMenuButton.setText("Menu");
        myMenu.add(myMenuButton);

        //Create and add "Save" Button
        JButton mySaveButton = new JButton();
        mySaveButton.setText("Save");
        myMenu.add(mySaveButton);

        //Create and add "Load" Button
        JButton myLoadButton = new JButton();
        myLoadButton.setText("Load");
        myMenu.add(myLoadButton);

        //Create and add "Help" Button
        JButton myHelpButton = new JButton();
        myHelpButton.setText("Help");
        myMenu.add(myHelpButton);
    }
}
