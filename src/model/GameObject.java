package model;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Abstract class for the objects that compose the game environment.
 * @author Robert
 * @version 1
 */
public abstract class GameObject extends JLabel {

    /**
     * ID that corresponds with enum CellType.ID
     */
    private final int myID;

    /**
     * ImageIcon used to draw the cell.
     */
    private final ImageIcon myIcon;

    /**
     * Enum for coordination and identification of cell.
     */
    private CellType myCellType = CellType.NONE;

    /**
     * Sets myIcon, myCellType, with the use of an ID argument.
     * @param theID Identification of GameObject
     */
    protected GameObject(final int theID) {
        myID = theID;
        myCellType = myCellType.assignCellType(myID);
        myIcon = new ImageIcon(myCellType.getFilename());
        setIcon(getMyIcon());
        setOpaque(true);
    }

    /**
     * Gets the GameObject ID.
     * @return int
     */
    public int getMyID() {
        return myID;
    }

    /**
     * gets the icon used to draw the GameObject.
     * @return ImageIcon
     */
    public ImageIcon getMyIcon() {
        return myIcon;
    }

    /**
     * Gets GameObjects CellType.
     * @return CellType
     */
    public CellType getMyCellType() {
        return myCellType;
    }

    /**
     * Assigns the concrete version of GameObject depending on the argument.
     * @param theID Determines the type to be returned.
     * @return GameObject
     */
    public static GameObject assignGameObject(final int theID) {
        return switch (theID) {
            case 0 -> new Floor();
            case 1 -> new Wall();
            case 2 -> new Door();
            case 3 -> new PickleRickAvatar();
            case 4 -> new Portal();
            case 10 -> new RickLife();
            default -> throw new IllegalStateException("Unexpected value: " + theID);
        };
    }
}
