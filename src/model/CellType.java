package model;

/**
 * Enumeration for cell types in the game environment.
 * TODO UML, pass file names to constructor.
 * TODO: size of cell type 50 x 50
 * @author Robert
 * @version 1
 */
public enum CellType {

    /**
     * Blank CellType, serves as a place holder.
     */
    NONE,
    WALL(0, "src/resources/test.png"),
    PLAYER(1, "filename");

    /**
     * ID that corresponds with GameObject.myID
     */
    private final int ID;

    /**
     * Filename for image being used to paint GameObjects composing environment.
     */
    private final String filename;

    /**
     * Constructor for NONE.
     */
    CellType() {
        ID = -1;
        filename = null;
    }

    /**
     * For initializing state of enums.
     * @param theID int
     * @param theFileName String
     */
    CellType(final int theID, final String theFileName) {
        ID = theID;
        filename = theFileName;
    }

    public int getID() {
        return ID;
    }

    public String getFilename() {
        return filename;
    }

    /**
     * Assigns a cell type when called.
     * @param theID int
     * @return CellType
     */
    public CellType assignCellType(final int theID) {
        CellType cellType;
        switch (theID) {
            case 0:
                cellType = CellType.WALL;
                break;
            case 1:
                cellType = CellType.PLAYER;
                break;
            default:
                System.err.println("In CellType.assignCellType() a cell type failed to be assigned.");
                cellType = CellType.NONE;
        }
        return cellType;
    }



}
