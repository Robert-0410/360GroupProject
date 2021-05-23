package view;



import sql.Question;

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
     * Current question the user is interacting with.
     */
    private Question myQuestion;

    /**
     * Labels used to display myQuestion information with paired button.
     *
     * 0 - Question,
     * 1 - Answer A,
     * 2 - Answer B,
     * 3 - Answer C,
     * 4 - Answer D
     */
    private JLabel[] myLabels;

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
     * Setter for current question.
     * @param theQuestion Question
     */
    public void setMyQuestion(final Question theQuestion) {
        myQuestion = theQuestion;
        // TODO also fill in the panel info to display.

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

//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        JLabel question = new JLabel("This is where the question will go: ");
//        question.setForeground(Color.LIGHT_GRAY);
//        add(question);

        instantiateLabels();
        instantiateButtons();
        buildAButton();
        buildBButton();
        buildCButton();
        buildDButton();
        addButtons();
    }

    /**
     * Instantiates the labels used to display myQuestion information.
     */
    private void instantiateLabels() {
        myLabels = new JLabel[5];
        for(int i = 0; i < myLabels.length; i++) {
            myLabels[i] = new JLabel();
        }
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
        a.setBounds(5, 30, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        a.setEnabled(false);

    }

    /**
     Builds and customizes the B answer button.
     */
    private void buildBButton() {
        var b = getBButton();

        b.setText("B");
        b.setBounds(5, 65, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        b.setEnabled(false);
    }

    /**
     Builds and customizes the C answer button.
     */
    private void buildCButton() {
        var c = getCButton();

        c.setText("C");
        c.setBounds(5, 100, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        c.setEnabled(false);
    }

    /**
     Builds and customizes D answer button.
     */
    private void buildDButton() {
        var d = getDButton();

        d.setText("D");
        d.setBounds(5, 135, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        d.setEnabled(false);
    }

    /**
     * Adds buttons to panel.
     */
    private void addButtons() {
        add(getAButton());
        add(getBButton());
        add(getCButton());
        add(getDButton());
    }


}
