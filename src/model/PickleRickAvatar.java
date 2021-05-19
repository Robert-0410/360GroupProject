package model;

/**
 * PickleRickAvatar is the Cell Type that is used
 * for the players avatar.
 */
public class PickleRickAvatar extends GameObject {

    /**
     * Sets myIcon, myCellType, with the use of an ID argument.

     */
    public PickleRickAvatar() {
        super(CellType.PLAYER.getID());
    }
}
