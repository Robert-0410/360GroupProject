package sql;


import java.io.Serializable;

/**
 * Object representation of the questions being asked.
 * @author Robert
 * @author Sasha
 */
public class Question implements Serializable {

    /**
     * Actual question.
     */
    private String myQuestion;

    /**
     * Answer choices.
     */
    private String[] myAnswers;

    /**
     * Index of correct question in myAnswers.
     */
    private int myCorrectIndex;


    /**
     * @return the actual question.
     */
    public String getMyQuestion(){
        return myQuestion;
    }


    /**
     * @param newQuestion actual question.
     */
    public void setMyQuestion(String newQuestion){
        this.myQuestion = newQuestion;
    }


    /**
     * @return Answers.
     */
    public String[] getMyAnswers(){
        return myAnswers;
    }


    /**
     * @param newAnswers the answers
     */
    public void setMyAnswers(final String[] newAnswers){
        this.myAnswers = newAnswers;
    }


    /**
     * @return the correct index for question.
     */
    public int getMyCorrectIndex(){
        return myCorrectIndex;
    }


    /**
     * @param newCorrectIndex the correct index.
     */
    public void setMyCorrectIndex(int newCorrectIndex){
        this.myCorrectIndex = newCorrectIndex;
    }
}

