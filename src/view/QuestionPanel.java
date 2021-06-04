package view;

import controller.listener.QuestionChoiceListener;
import sql.Question;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Contains the area the user will interact with the questions.
 * @author Robert
 * @version 1
 */
public final class QuestionPanel extends JPanel {

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
     * TextAreas used to display myQuestion information with paired button.
     *
     * 0 - Question,
     * 1 - Answer A,
     * 2 - Answer B,
     * 3 - Answer C,
     * 4 - Answer D
     */
    private JTextArea[] myTextAreas;

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
     * Setter for current question.
     * @param theQuestion Question
     */
    public void setMyQuestion(final Question theQuestion) {
        myQuestion = theQuestion;
        final var answers = myQuestion.getMyAnswers();

        // Set up similar properties for all text areas
        for (int i = 0; i < 5; i++){
            myTextAreas[i].setBackground(Color.DARK_GRAY);
            myTextAreas[i].setForeground(Color.WHITE);
            myTextAreas[i].setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 13));
            myTextAreas[i].setLineWrap(true);
            myTextAreas[i].setWrapStyleWord(true);
            myTextAreas[i].setEditable(false);
            myTextAreas[i].setText(myQuestion.getMyQuestion());
        }

        myTextAreas[0].setText(myQuestion.getMyQuestion());
        myTextAreas[0].setBounds(10, 2, 375, 30);

        // Set up text for all possible answers
        for (int i = 1; i < 5; i++) {
            myTextAreas[i].setText(answers[i-1]);
        }

        myTextAreas[1].setBounds(55, 40, 390, 20);
        myTextAreas[2].setBounds(55, 73, 390, 20);
        myTextAreas[3].setBounds(55, 106, 390, 20);
        myTextAreas[4].setBounds(55, 139, 390, 20);

    }


    /**
     * Returns current question the user is interacting with.
     * @return Question
     */
    public Question getMyQuestion() {
        return myQuestion;
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

        for (JTextArea myTextArea : myTextAreas) {
            myTextArea.setText("");
        }
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
        instantiateTextAreas();
        buildAButton();
        buildBButton();
        buildCButton();
        buildDButton();
        addButtonsAndTextAreas();
    }


    /**
     * Instantiates the TextAreas used to display myQuestion information.
     */
    private void instantiateTextAreas() {
        myTextAreas = new JTextArea[5];
        for(int i = 0; i < myTextAreas.length; i++) {
            myTextAreas[i] = new JTextArea();
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
        myButtons.get(0).setBounds(5, 35, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        myButtons.get(0).setEnabled(false);

    }


    /**
     Builds and customizes the B answer button.
     */
    private void buildBButton() {
        myButtons.get(1).setText("B");
        myButtons.get(1).addActionListener(new QuestionChoiceListener());
        myButtons.get(1).setBounds(5, 68, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        myButtons.get(1).setEnabled(false);
    }

    /**
     Builds and customizes the C answer button.
     */
    private void buildCButton() {
        myButtons.get(2).setText("C");
        myButtons.get(2).addActionListener(new QuestionChoiceListener());
        myButtons.get(2).setBounds(5, 101, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        myButtons.get(2).setEnabled(false);
    }


    /**
     Builds and customizes D answer button.
     */
    private void buildDButton() {
        myButtons.get(3).setText("D");
        myButtons.get(3).addActionListener(new QuestionChoiceListener());
        myButtons.get(3).setBounds(5, 134, PaneConst.QUESTION_BUTTON_WIDTH.value(), PaneConst.QUESTION_BUTTON_HEIGHT.value());
        myButtons.get(3).setEnabled(false);
    }


    /**
     * Adds buttons and labels to panel.
     */
    private void addButtonsAndTextAreas() {
        add(myButtons.get(0));
        add(myButtons.get(1));
        add(myButtons.get(2));
        add(myButtons.get(3));
        add(myTextAreas[0]);
        add(myTextAreas[1]);
        add(myTextAreas[2]);
        add(myTextAreas[3]);
        add(myTextAreas[4]);
    }

}
