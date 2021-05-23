package view;



import javax.swing.*;
import java.awt.*;

/**
 * Contains the area the user will interact with the questions.
 * @author Robert
 * @version 1
 */
public class QuestionPanel extends JPanel {

    /**
     * Unique instance of the question panel that allows user to interact with questions.
     */
    private static QuestionPanel UNIQUE_INSTANCE;

    /**
     * Holds the buttons for the answer choices.
     * 0 - A button
     * 1 - B button
     * 2 - C button
     * 3 - D button
     */
    private final JButton[] myButtons = new JButton[4];

    /**
     * Singleton style constructor.
     */
    private QuestionPanel() {
        buildPanel();
    }

    /**
     * Accessor for the unique instance of the question panel.
     * @return UNIQUE_INSTANCE
     */
    public static QuestionPanel getInstance() {
        if(UNIQUE_INSTANCE == null) {
            UNIQUE_INSTANCE = new QuestionPanel();
        }
        return UNIQUE_INSTANCE;
    }

    /**
     * Gets the A/True answer button.
     * @return JButton
     */
    public JButton getAButton() {
        return myButtons[0];
    }

    /**
     * Gets the B/False answer button.
     * @return JButton
     */
    public JButton getBButton() {
        return myButtons[1];
    }

    /**
     * Gets the C answer button.
     * @return JButton
     */
    public JButton getCButton() {
        return myButtons[2];
    }

    /**
     * Gets the D answer button.
     * @return JButton
     */
    public JButton getDButton() {
        return myButtons[3];
    }

    /**
     * Consolidates all private methods that build the Question area panel.
     * This is where change the answer button orientation and add the label which
     * will contain the question we ask the user.
     *
     */
    private void buildPanel() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2, true));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel question = new JLabel("This is where the question will go: ");
        question.setForeground(Color.LIGHT_GRAY);
        add(question);

        instantiateButtons();
        buildAButton();
        buildBButton();
        buildCButton();
        buildDButton();
        addButtons();
    }



    /**
     Instantiates the answer buttons into array.
     */
    private void instantiateButtons() {
        for(int i = 0; i < myButtons.length; i++) {
            myButtons[i] = new JButton();
        }
    }

    /**
     Builds and customizes the A answer button.
     */
    private void buildAButton() {
        var a = getAButton();

        a.setText("A");
        a.setEnabled(false);

    }

    /**
     Builds and customizes the B answer button.
     */
    private void buildBButton() {
        var b = getBButton();

        b.setText("B");
        b.setEnabled(false);
    }

    /**
     Builds and customizes the C answer button.
     */
    private void buildCButton() {
        var c = getCButton();

        c.setText("C");
        c.setEnabled(false);
    }

    /**
     Builds and customizes D answer button.
     */
    private void buildDButton() {
        var d = getDButton();

        d.setText("D");
        d.setEnabled(false);
    }

    /**
     * Adds buttons to panel.
     * TODO UML
     */
    private void addButtons() {
        add(getAButton());
        add(getBButton());
        add(getCButton());
        add(getDButton());
    }


}
