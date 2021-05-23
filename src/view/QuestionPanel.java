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
        var answers = myQuestion.getMyAnswers();
        // TODO also fill in the panel info to display.
        myLabels[0].setText(myQuestion.getMyQuestion());
        myLabels[0].setForeground(Color.CYAN);
        myLabels[0].setBounds(10, 10, 450, 12);

        myLabels[1].setText(answers[0]);
        myLabels[1].setForeground(Color.CYAN);
        myLabels[1].setBounds(55, 35, 450, 12);

        myLabels[2].setText(answers[1]);
        myLabels[2].setForeground(Color.CYAN);
        myLabels[2].setBounds(55, 70, 450, 12);

        myLabels[3].setText(answers[2]);
        myLabels[3].setForeground(Color.CYAN);
        myLabels[3].setBounds(55, 105, 450, 12);

        myLabels[4].setText(answers[3]);
        myLabels[4].setForeground(Color.CYAN);
        myLabels[4].setBounds(55, 140, 450, 12);

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

        instantiateLabels();
        instantiateButtons();
        buildAButton();
        buildBButton();
        buildCButton();
        buildDButton();
        addButtonsAndLabels();
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
     * Adds buttons and labels to panel.
     */
    private void addButtonsAndLabels() {
        add(getAButton());
        add(getBButton());
        add(getCButton());
        add(getDButton());

        // Labels TODO: add the rest of labels
        add(myLabels[0]);
        add(myLabels[1]);
        add(myLabels[2]);
        add(myLabels[3]);
        add(myLabels[4]);
    }


}
