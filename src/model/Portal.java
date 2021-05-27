package model;

import java.awt.Color;

/**
 * GameObject to win the game.
 * @author Robert
 * @version 1
 */
public class Portal extends GameObject {

    /**
     * Call super for proper instantiation ID.
     */
    Portal() {
        super(CellType.PORTAL.getID());
        final Color backgroundColor = new Color(54,117,135);
        setBackground(backgroundColor);
    }
}
