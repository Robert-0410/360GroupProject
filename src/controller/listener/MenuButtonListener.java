package controller.listener;


import view.MenuPanel;
import java.awt.event.ActionEvent;


/**
 * Handles actions related to the Menu Button.
 * @author seanlogan, Robert
 * @version 1
 */
public class MenuButtonListener extends GameListener {

    /**
     * For the MenuButton.
     */
    public MenuButtonListener() {
        super();
    }


    /**
     * Invoked when an action occurs.
     * @param e the event to be handled.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        MenuPanel.getInstance().displayMenuButtonOptions();
    }
}