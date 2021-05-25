package controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Controls the audo for the game.
 * @author seanlogan
 * @version 1
 */
public class GameAudio {

    /**
     *
     */
    public GameAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("src/resources/RickAndMortyThemeSong.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);


        clip.start();
    }

}
