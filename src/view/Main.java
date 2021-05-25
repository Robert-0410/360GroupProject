package view;

import controller.GameAudio;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * Game is ran from here.
 * @author Robert
 * @version 1
 */
public class Main {

    /**
     * main
     * @param args n/a
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //Force switch to universal UI theming.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        //
        final Game game = Game.getInstance();
        game.display();
        GameAudio gameAudio = new GameAudio();

    }
}
