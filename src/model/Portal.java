package model;

/**
 * GameObject to win the game.
 * @author Robert
 * @version 1
 */
public class Portal extends GameObject {

    /**
     * Call super for proper instantiation.
     */
    Portal() {
        super(CellType.PORTAL.getID());
    }
}
