package tests;

import org.junit.*;
import sql.Question;
import sql.QuestionManager;

import java.sql.*;


/** @author sasha
 * version 1.1.3
 *
 * This class exsits to test the database and to ensure that we are getting the correct, corresponding data
 * from each table and questions. This test class also checks to make sure the correct answer is being pulled
 *
 * This class also tests to make sure we are pulling child questions vs adult.
 *
 *
 */

public class QuestionManagerTests {
    static Connection connection = null;

    /**
     *  The @Before class creates a connection to a new test database. Its then filled with a couple
     *  different questions to make sure our QuestionManager is working correctly.
     */

    @BeforeClass
    public static void beforeClass() {
        // create connection to test database
        try {
            connection  = DriverManager.getConnection("jdbc:sqlite:tests.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists multiple_choice");
            statement.executeUpdate("create table multiple_choice (question string, optionA string, optionB string,  optionC string,  optionD string, answer string, isAdult int)");
            String query1 = "INSERT INTO multiple_choice ( question, optionA, optionB, optionC, optionD, answer, isAdult) VALUES ( 'What universe does Rick call home?', 'I dunno my own universe', 'S-420', 'C-137', 'M-31', '2', '0')";
            String query2 = "INSERT INTO multiple_choice ( question, optionA, optionB, optionC, optionD, answer, isAdult ) VALUES ( 'What is the name of Rick''s band?', 'Jaw Droppers', 'Flesh Curtains', 'Smash Bros', 'Toke and Smoke', '1', '1' )";

            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            connection.close();
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }

    }


    @Test
    public void tests_get_random_child_question() {
        QuestionManager questionManager = new QuestionManager("jdbc:sqlite:tests.db");
        Question question = questionManager.getRandomMultipleChoiceQuestion(false);
        Assert.assertTrue(question.getMyQuestion().equals("What universe does Rick call home?"));
        Assert.assertEquals(question.getMyCorrectIndex(),2);
    }

    @Test
    public void tests_get_random_adult_question(){
        QuestionManager questionManager = new QuestionManager("jdbc:sqlite:tests.db");
        Question question = questionManager.getRandomMultipleChoiceQuestion(true);
        Assert.assertTrue(question.getMyQuestion().equals("What is the name of Rick's band?"));
        Assert.assertEquals(question.getMyCorrectIndex(),1);

    }
}