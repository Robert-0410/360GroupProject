package controller.listener.menupanel;

import controller.listener.GameListener;
import view.MenuPanel;
import java.awt.event.ActionEvent;

/**
 * Listener for HelpButton.
 * @author Sean Logan
 * @version 1
 */
public class HelpButtonListener extends GameListener {

    /**
     * Used for the help button.
     */
    public HelpButtonListener() {
        super();
    }

    /**
     * Invoked when an action occurs.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MenuPanel.getInstance().displayHelp();
    }
}
