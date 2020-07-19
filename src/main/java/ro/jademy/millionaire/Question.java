package ro.jademy.millionaire;

public class Question {
    public String questionAsked;
    public String answerA;
    public String answerB;
    public String answerC;
    public String answerD;
    public String answerCorrect;
    public int difficultyLevel;

    public Question() {
        //default constructor
    }

    public Question(int difficultyLevel, String questionAsked, String answerA, String answerB, String answerC, String answerD, String answerCorrect) {
        this.difficultyLevel = difficultyLevel;
        this.questionAsked = questionAsked;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerCorrect = answerCorrect;
    }

//    public int getDifficultyLevel() {
//        return this.difficultyLevel;
//    }
//
//    public int setDifficultyLevel() {
//        return this.difficultyLevel;
//    }
//
//    public String getQuestionAsked() {
//        return this.questionAsked;
//    }
//
//    public String setQuestionAsked() {
//        return this.questionAsked;
//    }
//
//    public String getAnswerA() {
//        return this.answerA;
//    }
//
//    public String setAnswerA() {
//        return this.answerA;
//    }
//
//    public String getAnswerB() {
//        return this.answerB;
//    }
//
//    public String setAnswerB() {
//        return this.answerB;
//    }
//
//    public String getAnswerC() {
//        return this.answerC;
//    }
//
//    public String setAnswerC() {
//        return this.answerC;
//    }
//
//    public String getAnswerD() {
//        return this.answerD;
//    }
//
//    public String setAnswerD() {
//        return this.answerD;
//    }
//
//    public String getAnswerCorrect() {
//        return this.answerCorrect;
//    }
//
//    public String setAnswerCorrect() {
//        return this.answerCorrect;
//    }

}
