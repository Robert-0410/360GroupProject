package model;

/**
 * Cell Type Door, when the user approaches the
 * Door cell type, a question will be asked.
 * @author Robert
 * @version 1
 */
public class Door extends GameObject {

    /**
     * Calls super constructor with proper ID.
     */
    Door() {
        super(CellType.DOOR.getID());
    }
}
