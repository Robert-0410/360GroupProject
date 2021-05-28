package model;

import java.awt.*;

/**
 * Representation of user on the environment.
 * @author Robert
 * @version 1
 */
public class RickLife extends GameObject{

    /**
     * Calls super contractor with proper ID.
     */
    RickLife() {
        super(CellType.LIFE.getID());
        setBackground(Color.DARK_GRAY);
    }
}
