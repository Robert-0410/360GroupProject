package controller;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import java.io.File;

/**
 * Controls the audio for the game.
 * @author seanlogan, Robert
 * @version 1
 */
public final class GameAudio {

    /**
     * Stub constructor to prevent instantiation.
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
        } catch (final Exception e) {
            System.err.println("No Theme Song Found in GameAudio.themeSong()");
        }
    }


    /**
     * Audio that plays when the user selects the correct answer.
     */
    public static void wubbaLubba() {
        try {
            final File themeSong = new File("src/resources/WubbaLubbaDubDub.wav");
            final AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            final Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (final Exception e) {
            System.err.println("No Wubba Lubba Dub Dub Found in GameAudio.wubbaLubba().");
        }
    }


    /**
     * Audio that plays when the user selects the wrong answer.
     */
    public static void wrongAnswer() {
        try {
            final File themeSong = new File("src/resources/RickWrongAnswer.wav");
            final AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            final Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (final Exception e) {
            System.err.println("No Wrong Answer Found in GameAudio.wrongAnswer().");
        }
    }


    /**
     * Audio that plays when the user wins the game.
     */
    public static void winnerSong() {
        try {
        final File themeSong = new File("src/resources/GameWon.wav");
        final AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
        final Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    } catch (final Exception e) {
        System.err.println("No Game Lost wound found from GameAudio.winnerSong().");
    }
    }


    /**
     * Audio that plays when the user loses the game.
     */
    public static void gameLost() {
        try {
            //Call this when the user answers the wrong answer
            final File themeSong = new File("src/resources/GameLost.wav");
            final AudioInputStream audioStream = AudioSystem.getAudioInputStream(themeSong);
            final Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (final Exception e) {
            System.err.println("No Game Lost wound found from GameAudio.gameLost().");
        }
    }

}
