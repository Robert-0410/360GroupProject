package view;

import javax.swing.*;

/**
 * Game is ran from here.
 */
public class Main {

    /**
     * main
     * @param args n/a
     */
    public static void main(String[] args) {
        //Force switch to universal UI theming.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        final Game game = Game.getInstance();
        game.display();
    }
}
