package view;

/**
 * All constants used for the GUI.
 * @author Robert
 * @version 1
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
    SOUTH_HEIGHT(164),

    /**
     * Width and Height of the arrow buttons.
     */
    ARROW_SIZE(55),

    /**
     * Width of the buttons inside of QuestionPanel.
     */
    QUESTION_BUTTON_WIDTH(45),

    /**
     * Height of the buttons inside of QuestionPanel.
     */
    QUESTION_BUTTON_HEIGHT(25),

    /**
     * Size of the content selector size.
     */
    CONTENT_SELECTOR_SIZE(200),


    /**
     * Height of environment.
     */
    ENVIRONMENT_HEIGHT(450),

    /**
     * Height of Help Frame
     */
    HELP_HEIGHT(630),

    /**
     * Width of Help Frame
     */
    HELP_WIDTH(475);

    /**
     * Value of Constant.
     */
    private final int myValue;

    /**
     * Sets value.
     * @param theValue of the constant.
     */
    PaneConst(final int theValue) {
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
