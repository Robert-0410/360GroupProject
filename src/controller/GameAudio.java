package controller;

import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.io.File;


/**
 * Controls the audio for the game.
 * @author seanlogan
 * @version 1
 */
public class GameAudio {

    /**
     * Stores controls the game audio files and logic.
     */
    private GameAudio() {
    }

    public static void themeSong() {
        try {
            final File themeSong = new File("src/resources/RickAndMortyThemeSong.wav");
            final AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            final Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("No Theme Song Found.");
        }
    }

    public static void wubbaLubba() {
        try {
            //Call this when the user answers the correct answer
            File themeSong = new File("src/resources/WubbaLubbaDubDub.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("No Wubba Lubba Dub Dub Found.");
        }
    }

    public static void winnerSong() {
        //Call this when the user wins the game.
    }
}
