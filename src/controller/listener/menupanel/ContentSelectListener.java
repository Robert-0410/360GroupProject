package controller.listener.menupanel;

import controller.listener.GameListener;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;

/**
 * Listener for the "Ok" button available when selecting content. Adult vs Child. Game initiates in Child mode.
 * @author Robert
 * @version 1
 */
public class ContentSelectListener extends GameListener {

    /**
     * Helps determine is this choice was picked for logic in actionPerformed().
     */
    private final JRadioButton childContent;

    /**
     * The frame holding the Select button.
     */
    private final JFrame myFrame;


    /**
     * Receives the child selection option to determine if it was selected.
     * @param theChildChoice JRadioButton for child mode
     * @param theHoldingFrame JFrame holding button
     */
    public ContentSelectListener(final JRadioButton theChildChoice, final JFrame theHoldingFrame) {
        super();
        childContent = theChildChoice;
        myFrame = theHoldingFrame;
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        getEnvironmentManager().setInChildMode(childContent.isSelected());
        myFrame.dispose();
    }
}
