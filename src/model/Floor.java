package model;

/**
 * Cell type of Floor is the area the player will
 * walk on.
 * @author Robert
 * @version 1
 */
public class Floor extends GameObject {

    /**
     * Utilizes super contractor with proper ID for instantiation.
     */
    Floor() {
        super(CellType.FLOOR.getID());
    }
}
