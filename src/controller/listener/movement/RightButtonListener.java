package controller.listener.movement;

import controller.listener.GameListener;
import java.awt.event.ActionEvent;

/**
 * Listener for the right move button.
 * @author Robert
 * @version 1
 */
public class RightButtonListener extends GameListener {

    /**
     * Used for the right move button.
     */
    public RightButtonListener() {
        super();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        getEnvironmentManager().movePlayerRight();
    }
}
