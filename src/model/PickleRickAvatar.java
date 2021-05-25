package model;

import java.awt.*;

/**
 * PickleRickAvatar is the Cell Type that is used
 * for the players avatar.
 */
public class PickleRickAvatar extends GameObject {

    /**
     * Sets myIcon, myCellType, with the use of an ID argument.

     */
    PickleRickAvatar() {
        super(CellType.PLAYER.getID());
        Color backgroundColor = new Color(54,117,135);
        setBackground(backgroundColor);
    }
}
