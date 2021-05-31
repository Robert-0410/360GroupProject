package sql;

import java.sql.*;

import org.sqlite.SQLiteDataSource;

/**
 *
 * @author sasha amador
 * @version 1.1.03
 *
 * The QuestionManager class connects our database, and is where our getMultipleChoice method is located.
 *
 *
 * the getMultipleChoice method first does a parameter test to see if the user is playing in adult mode or
 * child mode. From there the maze will be populated with random questions from the database which reflects
 * the mode they are playing in
 */
public class QuestionManager {

    Connection connection = null;

    public QuestionManager() {
        databaseConnectionSetup();
    }

    private void databaseConnectionSetup(){
        //establish connection (creates db file if it does not exist :-)
        try {
            connection  = DriverManager.getConnection("jdbc:sqlite:questions.db");

        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public Question getRandomMultipleChoiceQuestion(boolean isAdult) {
        Question questionBank = new Question();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String isAdultString = (isAdult) ? "1" : "0";

            // added more questions to database to help ensure we don't get repeated questions
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM multiple_choice WHERE isAdult=%s ORDER BY RANDOM() LIMIT 1", isAdultString));
            // read the result set
            String[] answers = new String[4];
            answers[0] = rs.getString("optionA");
            answers[1] = rs.getString("optionB");
            answers[2] = rs.getString("optionC");
            answers[3] = rs.getString("optionD");

            questionBank.setMyAnswers(answers);
            questionBank.setMyQuestion(rs.getString("question"));
            questionBank.setMyCorrectIndex( rs.getInt("answer"));
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }

        return questionBank;
    }
}