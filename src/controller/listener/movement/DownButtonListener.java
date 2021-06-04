package controller.listener.movement;


import controller.listener.GameListener;

import java.awt.event.ActionEvent;

/**
 * Listener for the down move button.
 * @author Robert
 * @version 1
 */
public class DownButtonListener extends GameListener {

    /**
     * Used for the down move button.
     */
    public DownButtonListener() {
        super();
    }



    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        getEnvironmentManager().movePlayerDown();
    }
}
