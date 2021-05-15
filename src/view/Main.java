package view;

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
    public static void main(String[] args) {
        final Game game = Game.getInstance();
        game.display();
    }
}
