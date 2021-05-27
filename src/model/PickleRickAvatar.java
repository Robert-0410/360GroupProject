package model;

import java.awt.Color;

/**
 * PickleRickAvatar is the Cell Type that is used
 * for the players avatar.
 * @author Robert
 * @version 1
 */
public class PickleRickAvatar extends GameObject {

    /**
     * Uses super contractor with proper ID for instantiation.
     */
    PickleRickAvatar() {
        super(CellType.PLAYER.getID());
        final Color backgroundColor = new Color(54,117,135);
        setBackground(backgroundColor);
    }
}
