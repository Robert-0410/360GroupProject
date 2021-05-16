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
     *
     */
    private final ImageIcon myIcon;
    private CellType myCellType = CellType.NONE;

    /*
      1020321
     */
    protected GameObject(final int theID) {
        myID = theID;
        myCellType = myCellType.assignCellType(myID);
        myIcon = new ImageIcon(myCellType.getFilename());
        setIcon(getMyIcon());

        setOpaque(true);
    }

    public int getMyID() {
        return myID;
    }

    public ImageIcon getMyIcon() {
        return myIcon;
    }
}
