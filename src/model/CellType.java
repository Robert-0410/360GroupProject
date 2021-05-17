package model;

/**
 * Enumeration for cell types in the game environment.
 * @author Robert
 * @version 1
 */
public enum CellType {

    /**
     * Blank CellType, serves as a place holder.
     */
    NONE,
    WALL(0, "src/resources/test.png"),
    FLOOR(1, "filename"),
    DOOR(2, "filename"),
    PLAYER(3, "filename");

    /**
     * ID that corresponds with GameObject.myID
     */
    private final int ID;

    /**
     * Filename for image being used to paint GameObjects composing environment.
     */
    private final String filename;

    /**
     * Constructor for NONE. Place holder
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

    /**
     * Gets the identification for the CellType.
     * @return int
     */
    public int getID() {
        return ID;
    }

    /**
     * Gets the filename used to draw the image.
     * @return String
     */
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
            case 0 -> cellType = CellType.WALL;
            case 1 -> cellType = CellType.FLOOR;
            case 2 -> cellType = CellType.DOOR;
            case 3 -> cellType = CellType.PLAYER;
            default -> {
                System.err.println("In CellType.assignCellType() a cell type failed to be assigned.");
                cellType = CellType.NONE;
            }
        }
        return cellType;
    }



}
