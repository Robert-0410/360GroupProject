package view;

/**
 * All constants used for the GUI.
 * @author Robert
 * @version 1
 * TODO UML all and documentation
 * TODO Team: Please use this enum to add any constants you need for panel fields.
 */
public enum PaneConst {

    /**
     * Width of overall window.
     */
    WINDOW_WIDTH(900),

    /**
     * Height of overall window.
     */
    WINDOW_HEIGHT(650),

    /**
     * Height of the SOUTH panel that holds ButtonPanel and QuestionPanel.
     */
    SOUTH_HEIGHT(150),

    /**
     * Width and Height of the arrow buttons.
     */
    ARROW_SIZE(50);


    /**
     * Value of Constant.
     */
    private final int myValue;

    /**
     * Sets value.
     * @param theValue of the constant.
     */
    PaneConst(int theValue) {
        myValue = theValue;
    }

    /**
     * Accessor for constant.
     * @return myValue of constant.
     */
    public int value() {
        return myValue;
    }

}
