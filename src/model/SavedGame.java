package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A saved game that a user can load.
 * @author Robert
 * @version 1
 */
public class SavedGame implements Serializable {

    /**
     * For serializing the object.
     */
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


    /**
     * Parameterless constructor.
     */
    public SavedGame() {}


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

    /**
     * @return ArrayList representation of the map to be painted.
     */
    public ArrayList<List<GameObject>> getMyMap() {
        return myMap;
    }

    /**
     * @return The row the user is located on.
     */
    public int getMyUserRow() {
        return myUserRow;
    }


    /**
     * @return The column the user is located on.
     */
    public int getMyUserCol() {
        return myUserCol;
    }


    /**
     * @return The lives user has.
     */
    public int getMyUserLives() {
        return myUserLives;
    }

    /**
     * @return the content mode selection.
     */
    public boolean isInChildMode() {
        return isInChildMode;
    }
}
