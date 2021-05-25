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
    FLOOR(0, "src/resources/FloorCell.png", 25, 25),
    WALL(1, "src/resources/WallCell.png", 25, 25),
    DOOR(2, "src/resources/DoorCell.png", 25, 25),
    PLAYER(3, "src/resources/PickleRickAvatar.png", 25, 25),
    PORTAL(4,"src/resources/RickPortal.png", 25, 25),
    LIFE(10, "src/resources/RickLifeCount.png", 50, 100);


    /**
     * ID that corresponds with GameObject.myID
     */
    private final int ID;

    /**
     * Filename for image being used to paint GameObjects composing environment.
     */
    private final String filename;

    /**
     * cellSize x cellSize of cell.
     */
    private final int cellWidth;

    /**
     * Height of cell, typically this is the same as cellWidth.
     */
    private final int cellHeight;

    /**
     * Constructor for NONE. Place holder
     */
    CellType() {
        ID = -1;
        filename = null;
        cellWidth = 0;
        cellHeight = 0;
    }

    /**
     * For initializing state of enums.
     * @param theID int
     * @param theFileName String
     */
    CellType(final int theID, final String theFileName, final int theWidth, final int theHeight) {
        ID = theID;
        filename = theFileName;
        cellWidth = theWidth;
        cellHeight = theHeight;
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
     * Gets the individual size of the respective cell.
     * @return int
     */
    public int getCellWidth() {
        return cellWidth;
    }

    /**
     * Gets the Height of the respective cell.
     * @return int
     */
    public int getCellHeight() {
        return cellHeight;
    }

    /**
     * Assigns a cell type when called.
     * @param theID int
     * @return CellType
     */
    public CellType assignCellType(final int theID) {
        CellType cellType;
        switch (theID) {
            case 0 -> cellType = CellType.FLOOR;
            case 1 -> cellType = CellType.WALL;
            case 2 -> cellType = CellType.DOOR;
            case 3 -> cellType = CellType.PLAYER;
            case 4 -> cellType = CellType.PORTAL;
            case 10 -> cellType = CellType.LIFE;
            default -> {
                System.err.println("In CellType.assignCellType() a cell type failed to be assigned.");
                cellType = CellType.NONE;
            }
        }
        return cellType;
    }



}
