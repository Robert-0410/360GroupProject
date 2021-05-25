package model;

/**
 * Wall barrier that does not allow player to wald through.
 * @author Robert
 * @version 1
 */
public class Wall extends GameObject {

    /**
     * Constructor that uses super to fill abstracted fields.
     */
    Wall() {
        super(CellType.WALL.getID());
    }
}
