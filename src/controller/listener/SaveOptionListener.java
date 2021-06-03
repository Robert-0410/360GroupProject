package controller.listener;


import view.MenuPanel;
import java.awt.event.ActionEvent;


/**
 * Handles actions related to the Save Button.
 * @author seanlogan, Robert
 * @version 1
 */
public class SaveOptionListener extends GameListener {

    /**
     * For the SaveOptionListener.
     */
    public SaveOptionListener() {
        super();
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be handled.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        MenuPanel.getInstance().displaySaveGameOptions();
    }
}