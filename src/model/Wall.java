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
    protected Wall() {
        super(CellType.WALL.getID());
    }
}
