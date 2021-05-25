package controller;

import javax.sound.sampled.*;
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

    /**
     * Audio that plays when the game is opened.
     */
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

    /**
     * Audio that plays when the user selects the correct answer.
     */
    public static void wubbaLubba() {
        try {
            File themeSong = new File("src/resources/WubbaLubbaDubDub.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("No Wubba Lubba Dub Dub Found.");
        }
    }

    /**
     * Audio that plays when the user selects the wrong answer.
     */
    public static void wrongAnswer() {
        try {
            File themeSong = new File("src/resources/RickWrongAnswer.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("No Wrong Answer Found.");
        }
    }

    /**
     * Audio that plays when the user wins the game.
     */
    public static void winnerSong() {
        //Call this when the user wins the game.
    }

    /**
     * Audio that plays when the user loses the game.
     */
    public static void gameLost() {
        try {
            //Call this when the user answers the wrong answer
            File themeSong = new File("src/resources/GameLost.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("No Game Lost Found.");
        }
    }

}
