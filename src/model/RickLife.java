package model;

import java.awt.*;

public class RickLife extends GameObject{

    /**
     * Sets myIcon, myCellType, with the use of an ID argument.
     *
     */
    RickLife() {
        super(CellType.LIFE.getID());
        setBackground(Color.DARK_GRAY);
    }
}
