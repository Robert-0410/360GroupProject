package controller.listener;


import java.awt.event.ActionEvent;

/**
 * Listener for the up move button.
 * @author Robert
 * @version 1
 */
public class UpButtonListener extends GameListener {

    /**
     * Used for the up move button.
     */
    public UpButtonListener() {
        super();
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        getEnvironmentManager().movePlayerUp();
    }
}