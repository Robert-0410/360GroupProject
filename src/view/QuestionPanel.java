package view;



import controller.QuestionChoiceListener;
import sql.Question;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    private final ArrayList<JButton> myButtons;

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
        myButtons = new ArrayList<>();
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
     * Enables question buttons to be used by the user.
     */
    public void enableButtons() {
        myButtons.get(0).setEnabled(true);
        myButtons.get(1).setEnabled(true);
        myButtons.get(2).setEnabled(true);
        myButtons.get(3).setEnabled(true);
    }

    /**
     * Disables question buttons after question is answered correctly and clear labels.
     */
    public void disableButtons() {
        myButtons.get(0).setEnabled(false);
        myButtons.get(1).setEnabled(false);
        myButtons.get(2).setEnabled(false);
        myButtons.get(3).setEnabled(false);

        for (JLabel myLabel : myLabels) {
            myLabel.setText("");
        }
    }

    /**
     * Setter for current question.
     * @param theQuestion Question
     */
    public void setMyQuestion(final Question theQuestion) {
        myQuestion = theQuestion;
        var answers = myQuestion.getMyAnswers();

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
     * Returns current question the user is interacting with.
     * @return Question
     */
    public Question getMyQuestion() {
        return myQuestion;
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

        instantiateButtons();
        instantiateLabels();
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
        for(int i = 0; i < 4; i++) {
            myButtons.add(new JButton());
        }
    }

    /**
     Builds and customizes the A answer button.
     */
    private void buildAButton() {
        myButtons.get(0).setText("A");
        myButtons.get(0).addActionListener(new QuestionChoiceListener());
        myButtons.get(0).setBounds(5, 30, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        myButtons.get(0).setEnabled(false);

    }

    /**
     Builds and customizes the B answer button.
     */
    private void buildBButton() {
        myButtons.get(1).setText("B");
        myButtons.get(1).addActionListener(new QuestionChoiceListener());
        myButtons.get(1).setBounds(5, 65, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        myButtons.get(1).setEnabled(false);
    }

    /**
     Builds and customizes the C answer button.
     */
    private void buildCButton() {
        myButtons.get(2).setText("C");
        myButtons.get(2).addActionListener(new QuestionChoiceListener());
        myButtons.get(2).setBounds(5, 100, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        myButtons.get(2).setEnabled(false);
    }

    /**
     Builds and customizes D answer button.
     */
    private void buildDButton() {
        myButtons.get(3).setText("D");
        myButtons.get(3).addActionListener(new QuestionChoiceListener());
        myButtons.get(3).setBounds(5, 135, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        myButtons.get(3).setEnabled(false);
    }

    /**
     * Adds buttons and labels to panel.
     */
    private void addButtonsAndLabels() {
        add(myButtons.get(0));
        add(myButtons.get(1));
        add(myButtons.get(2));
        add(myButtons.get(3));

        // Labels TODO: add the rest of labels
        add(myLabels[0]);
        add(myLabels[1]);
        add(myLabels[2]);
        add(myLabels[3]);
        add(myLabels[4]);
    }


}
