package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sasha amador
 * @author Robert & Sean
 * @version 1.2.08
 *
 * The QuestionManager class connects our database, and is where our getMultipleChoice method is located.
 *
 *
 * the getMultipleChoice method first does a parameter test to see if the user is playing in adult mode or
 * child mode. From there the maze will be populated with random questions from the database which reflects
 * the mode they are playing in
 *
 * This class also takes the questions that are stored into the database and places them into an array list.
 */
public class QuestionManager {

    Connection connection = null;


    /**
     * Holds questions for child content.
     */
    private final ArrayList<Question> myChildQuestions;

    /**
     * Holds questions for adult content.
     */
    private final ArrayList<Question> myAdultQuestions;


    /**
     * Constructor used in EnvironmentManager.
     * @param databaseName path to database
     */
    public QuestionManager(String databaseName) {
        databaseConnectionSetup(databaseName);

        myChildQuestions = new ArrayList<>();
        myAdultQuestions = new ArrayList<>();

    }


    /**
     * Returns the proper question for the content user is in.
     * @param isChild Flag to control what kind of question is returned.
     * @return question selected
     */
    public Question getRandomMultipleChoiceQuestion(final boolean isChild) {
        final Question question;
        // treating like a stack, '0' points to top.
        if (isChild) {
            question = myChildQuestions.remove(0);
        } else {
            question = myAdultQuestions.remove(0);
        }
        return question;
    }

    public void resetDataStructure() {
        myChildQuestions.clear();
        myAdultQuestions.clear();

        readFromDatabaseForChild();
        readFromDatabaseForAdult();
    }


    /**
     * Loads the myChildQuestion ArrayList
     */
    private void readFromDatabaseForChild(){

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String isAdultString = "0";
            duplicate(statement, isAdultString, myChildQuestions);
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Loads the myAdultQuestion ArrayList
     */
    private void readFromDatabaseForAdult(){

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String isAdultString = "1";
            duplicate(statement, isAdultString, myAdultQuestions);
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void duplicate(Statement statement, String isAdultString, ArrayList<Question> myAdultQuestions) throws SQLException {
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM multiple_choice WHERE isAdult=%s", isAdultString));

        while(rs.next()){
            Question question = new Question();
            // read the result set
            String[] answers = new String[4];
            answers[0] = rs.getString("optionA");
            answers[1] = rs.getString("optionB");
            answers[2] = rs.getString("optionC");
            answers[3] = rs.getString("optionD");

            question.setMyAnswers(answers);
            question.setMyQuestion(rs.getString("question"));
            question.setMyCorrectIndex( rs.getInt("answer"));
            myAdultQuestions.add(question);

        }

        Collections.shuffle(myAdultQuestions);


        rs.close();
    }

    /**
     * the databaseConnectionSetup sets up the database.
     */
    private void databaseConnectionSetup(String databaseName) {
        try {
            connection = DriverManager.getConnection(databaseName);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
