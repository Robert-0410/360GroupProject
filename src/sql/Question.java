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

    public String getMyQuestion(){
        return myQuestion;
    }

    public void setMyQuestion(String newQuestion){
        this.myQuestion = newQuestion;
    }

    public String[] getMyAnswers(){
        return myAnswers;
    }

    public void setMyAnswers(String[] newAnswers){
        this.myAnswers = newAnswers;
    }
    public int getMyCorrectIndex(){
        return myCorrectIndex;
    }

    public void setMyCorrectIndex(int newCorrectIndex){
        this.myCorrectIndex = newCorrectIndex;
    }
}

