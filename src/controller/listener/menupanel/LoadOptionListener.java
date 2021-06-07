package controller.listener.menupanel;

import controller.listener.GameListener;
import view.MenuPanel;
import java.awt.event.ActionEvent;

/**
 * Handles actions related to the Load Button.
 * @author seanlogan, Robert
 * @version 1
 */
public class LoadOptionListener extends GameListener {

    /**
     * For the LoadOptionListener.
     */
    public LoadOptionListener() {
        super();
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be handled.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        MenuPanel.getInstance().displayLoadGameOptions();
    }
}