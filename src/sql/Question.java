package sql;

/** @author sasha
 *

 * This class is contains all the getters and setters for our questions, answers, and the correct index
 * for the question.
 *
 */


public class Question {
    private String myQuestion;
    private String[] myAnswers;
    private int myCorrectIndex;


    /**
     * This is the getter for myQuestion objects
     **/
    public String getMyQuestion(){
        return myQuestion;
    }

    /**
     * This is the sets the myQuestion objects
     **/

    public void setMyQuestion(String newQuestion){
        this.myQuestion = newQuestion;
    }

    /**
     * this is the getter for myAnswer objects
     */

    public String[] getMyAnswers(){
        return myAnswers;
    }
    /**
     * this is the setter for myAnswer objects
     */
    public void setMyAnswers(String[] newAnswers){
        this.myAnswers = newAnswers;
    }

    /**
     * this is the getter for myCorrectIndex objects
     */
    public int getMyCorrectIndex(){
        return myCorrectIndex;
    }

    /**
     * this is the set myCorrect index object
     */
    public void setMyCorrectIndex(int newCorrectIndex){
        this.myCorrectIndex = newCorrectIndex;
    }
}

