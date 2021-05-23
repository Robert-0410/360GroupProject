package sql;

import java.sql.*;

import org.sqlite.SQLiteDataSource;

/**
 *
 * @author tom capaul
 *
 * Simple class to demonstrate SQLite connectivity
 * 1) create connection
 * 2) add a table
 * 3) add entries to the table
 * 4) query the table for its contents
 * 5) display the results
 *
 * NOTE: any interactions with a database should utilize a try/catch
 * since things can go wrong
 *
 * @see <a href="https://shanemcd.org/2020/01/24/how-to-set-up-sqlite-with-jdbc-in-eclipse-on-windows/">
https://shanemcd.org/2020/01/24/how-to-set-up-sqlite-with-jdbc-in-eclipse-on-windows/</a>
 *
 */
public class QuestionManager {

    Connection connection = null;

    public QuestionManager() {
        super();
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

    public Question getRandomMultipleChoiceQuestion() {
        Question questionBank = new Question();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            // need to update to actually return a random question istead of just the first one
            ResultSet rs = statement.executeQuery("SELECT * FROM multiple_choice LIMIT 1");
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