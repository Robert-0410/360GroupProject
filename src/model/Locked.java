package model;

/**
 * Cell Type Locked, when the user gets a
 * question wrong DOOR type becomes LOCKED
 * @author Sean
 * @version 1
 */
public class Locked extends GameObject {

    /**
     * Calls super constructor with proper ID.
     */
    Locked() {
        super(CellType.LOCKED.getID());
    }
}