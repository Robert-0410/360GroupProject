package model;

/**
 * Wall barrier that does not allow player to walk through.
 * @author Robert
 * @version 1
 */
public class Wall extends GameObject {

    /**
     * Constructor that uses super to fill abstracted fields.
     * @param theID identification of GameObject
     */
    public Wall(final int theID) {
        super(theID);
    }
}
