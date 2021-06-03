package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sasha amador
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
    ArrayList<Question> questions = null;
    int currentIndex;



    public QuestionManager(String databaseName, boolean isAdult) {
        databaseConnectionSetup(databaseName);
        readFromDatabase(isAdult);
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

    /** The method getRandomMultipleChoiceQuestion will pull a random item, currentIndex
     * out of our array list and return it.
     */
    public Question getRandomMultipleChoiceQuestion() {
        Question question = questions.get(currentIndex);
        currentIndex++;
        return question;
    }

    /**
     * the readFromDatabase method takes in the parameter isAdult and makes sure that that parameter is set to
     *  return either child or adult questions.
     *
     *This function also takes the questions from our database and stores them into an arrayList and applies the
     * shuffle function to make sure the user is asked a random question when playing the game.
     *
     */
    private void readFromDatabase(boolean isAdult){
        this.questions = new ArrayList<Question>();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String isAdultString = (isAdult) ? "1" : "0";
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
                questions.add(question);

            }

            Collections.shuffle(this.questions);


            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}