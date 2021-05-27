package controller.listener;



import java.awt.event.ActionEvent;

/**
 * Listener for the left move button.
 * @author Robert
 * @version 1
 */
public class LeftButtonListener extends GameListener {

    /**
     * Used for the left move button.
     */
    public LeftButtonListener() {
        super();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        getEnvironmentGenerator().movePlayerLeft();
    }
}
