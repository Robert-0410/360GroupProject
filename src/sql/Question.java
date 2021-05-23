package sql;



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

