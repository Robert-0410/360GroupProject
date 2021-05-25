package model;

import java.awt.*;

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
        Color backgroundColor = new Color(54,117,135);
        setBackground(backgroundColor);
    }
}
