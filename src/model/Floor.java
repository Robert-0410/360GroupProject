package model;

/**
 * Cell type of Floor is the area the player will
 * walk on.
 */
public class Floor extends GameObject {

    /**
     * Sets myIcon, myCellType, with the use of an ID argument.
     */
    protected Floor() {
        super(CellType.FLOOR.getID());
    }
}
