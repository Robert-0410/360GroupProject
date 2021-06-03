package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A saved game that a user can load.
 */
public class SavedGame implements Serializable {


    /**
     * Current state of the map.
     */
    private ArrayList<List<GameObject>> myMap;

    /**
     * The current row location of saved game.
     */
    private int myUserRow = 1;

    /**
     * The current column location of saved game.
     */
    private int myUserCol = 1;

    /**
     * Lives user had when saving the current game.
     */
    private int myUserLives = 3;

    /**
     * Current content selected when user saves game.
     */
    private boolean isInChildMode;

    // TODO: remove if not needed
    // private Direction userIsMoving;



    /**
     * Parameterless constructor.
     */
    public SavedGame() {

    }

    // TODO: method to test whats going on with object.
    public void checkObject() {
        System.out.println("Number of lives: " + myUserLives);
    }


    /**
     * @param myMap 2D ArrayList holding GameObjects that compose the game environment.
     */
    public void setMyMap(ArrayList<List<GameObject>> myMap) {
        this.myMap = myMap;
    }


    /**
     * @param myUserRow user row location.
     */
    public void setMyUserRow(int myUserRow) {
        this.myUserRow = myUserRow;
    }


    /**
     * @param myUserCol user column location.
     */
    public void setMyUserCol(int myUserCol) {
        this.myUserCol = myUserCol;
    }


    /**
     * @param myUserLives user lives.
     */
    public void setMyUserLives(int myUserLives) {
        this.myUserLives = myUserLives;
    }


    /**
     * @param inChildMode flag for age content.
     */
    public void setInChildMode(boolean inChildMode) {
        isInChildMode = inChildMode;
    }
}
