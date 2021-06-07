package controller.listener.menupanel;

import controller.StatusManager;
import controller.listener.GameListener;
import view.ButtonPanel;
import view.QuestionPanel;
import java.awt.event.ActionEvent;

/**
 * Handles Actions related to the New Game button.
 * @author Robert
 * @version 1
 */
public class NewGameButtonListener extends GameListener {

    /**
     * For the NewGameButton.
     */
    public NewGameButtonListener() {
        super();
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        QuestionPanel.getInstance().removeGameWonLostQuestionText();
        StatusManager.enableGameButtons();
        getEnvironmentManager().resetIsWinningCell();
        getEnvironmentManager().getMyMap().clear();
        getEnvironmentManager().resetPlayerLocation();
        getEnvironmentManager().generateInitialEnvironment();
        getEnvironmentManager().resetPlayerLives();
        getEnvironmentManager().getQuestionManager().resetDataStructure();

        final var initialLives = 3;
        ButtonPanel.getInstance().addUserLives(initialLives);
    }
}
