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

    /**
     * Holds current question.
     */
    private String myQuestion;

    private String[] myAnswers;

    private int myCorrectIndex;

    SQLiteDataSource ds = null;

    /**
     * Sets the proper index for the correct answer in myAnswers.
     * @param theChar the character from the data base.
     */
    public void setCorrectIndex(final char theChar) {
        switch (theChar) {
            case 'a' -> myCorrectIndex = 0;
            case 'b' -> myCorrectIndex = 1;
            case 'c' -> myCorrectIndex = 2;
            case 'd' -> myCorrectIndex = 3;
            default -> {
                System.err.println("The correct index for the answers was not set in setCorrectIndex()");
            }
        }
    }



    public static void main(String[] args) {
        Connection connection = null;

        //establish connection (creates db file if it does not exist :-)
        try {
            connection  = DriverManager.getConnection("jdbc:sqlite:questions.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from multiple_choice");
            while(rs.next())
            {
                // read the result set
                System.out.println("question : " + rs.getString("question"));
                System.out.println("answer : " + rs.getString("answer"));
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}