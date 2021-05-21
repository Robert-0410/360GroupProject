package sql;

import java.sql.*;

/**@Author Sasha Amador
 * @version 1.0.0
 *
 */



public class Questions {
    public static void main(String[] args)
    {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sql/questionBank.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            /** '*' refers all the columns of the able and returns the
             * values for ALL of the columns from the table.
             *
             * % matches the literal symbol in the data --> use for answers
             */

            // want to play around with this a bit more
            ResultSet rs = statement.executeQuery("select * from multiple_choice");
            while(rs.next())
            {
                // read the result set
                System.out.println("question = " + rs.getString("question"));
                System.out.println("optionC = " + rs.getString("optionC"));
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

