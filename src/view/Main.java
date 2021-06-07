package view;

import controller.GameAudio;
import javax.swing.UIManager;

/**
 * Game is ran from here.
 * @author Robert
 * @version 1
 */
public final class Main {

    /**
     * main
     * @param args n/a
     */
    public static void main(String[] args) {
        //Force switch to universal UI theming.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        // Display GUI.
        final Game game = Game.getInstance();
        game.display();

        // Play theme song.
        GameAudio.themeSong();

    }
}
