package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A saved game that a user can load.
 */
public class SavedGame implements Serializable {

    private static final long serialversionUID = 129348938L;

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
    public SavedGame() {}

    // TODO: method to test whats going on with object.
    public void checkObject(final String checkingFrom) {
        System.out.println("Checking Object from " + checkingFrom + " " + myUserRow + ", " + myUserCol);
    }


    /**
     * @param myMap 2D ArrayList holding GameObjects that compose the game environment.
     */
    public void setMyMap(ArrayList<List<GameObject>> myMap) {
        this.myMap = myMap;
    }


    /**
     * @param theUserRow user row location.
     */
    public void setMyUserRow(int theUserRow) {
        myUserRow = theUserRow;
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

    public ArrayList<List<GameObject>> getMyMap() {
        return myMap;
    }

    public int getMyUserRow() {
        return myUserRow;
    }

    public int getMyUserCol() {
        return myUserCol;
    }

    public int getMyUserLives() {
        return myUserLives;
    }

    public boolean isInChildMode() {
        return isInChildMode;
    }
}
