package model;

/**
 * Cell Type Door, when the user approaches the
 * Door cell type, a question will be asked.
 */
public class Door extends GameObject {

    /**
     * Sets myIcon, myCellType, with the use of an ID argument.
     */
    Door() {
        super(CellType.DOOR.getID());
    }
}
