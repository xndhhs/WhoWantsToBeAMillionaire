package ro.jademy.millionaire;


import java.util.ArrayList;
import java.util.Scanner;

import static ro.jademy.millionaire.LibraryOfQuestions.*;

public class Game {
    static int[] rewardAmounts = new int[]{100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 25000, 500000, 1000000};
    static Scanner scanner = new Scanner(System.in);
    static int helpTries = 2;
    static boolean keepPlaying = true;

    public static void startGame() {
        LibraryOfQuestions.createPlayingQuestions();
        System.out.printf("Please enter your name:");
        String name = Game.scanner.next();
        System.out.println();
        System.out.println("Welcome, " + name + "! Let's play!");
        System.out.println("Rules:");
        System.out.println("-Each question has one correct answer out of 4. Answer correctly to all of them and win 1000000 EUR");
        System.out.println("-If you'll answer a question incorrectly you'll walk away with: 0 EUR for Q1 to Q5, 1000 EUR for Q6 to Q10, 32000 EUR for Q11 to Q14");
        System.out.println("-If you don't know the answer to a question, type <<help>> and 2 incorrect answers will disappear. You have 2 helps/game");
    }

    public static void gameQuestions( ArrayList<Question> questions ) {
        for (int i = 0; i < questions.size(); i++) {
            askQuestion(questions.get(i), i);
            answerQuestion(questions.get(i), i);
            System.out.println();
        }
    }

    public static void askQuestion( Question question, int i ) {
        System.out.printf("Question no." + (i + 1) + "   ");
        System.out.println(question.questionAsked);
        System.out.println(question.answerA + "    " + question.answerB);
        System.out.println(question.answerC + "    " + question.answerD);
    }

    public static void answerQuestion( Question questionAsked, int i ) {
        int gainedMoney = 0;
        System.out.printf("Enter your answer: ");
        String playerChoice = scanner.next();
        if (playerChoice.equalsIgnoreCase(questionAsked.answerCorrect)) {
            gainedMoney += rewardAmounts[i];
            System.out.println("Correct answer! You now have " + gainedMoney + " EUR!");
        } else if (playerChoice.equalsIgnoreCase("help")) {
            helpPlayer(questionAsked);
            answerQuestion(questionAsked, i);
        } else {
            if (i < 5) {
                System.out.println("The answer was incorrect! You have earned no money!");
                System.out.println();
                System.out.printf("Do you want to play again?");
                String playAgain = scanner.next();
                System.out.println();
                if (playAgain.equalsIgnoreCase("yes")) {
                    LibraryOfQuestions.createPlayingQuestions();
                    playAgain(LibraryOfQuestions.randomPlayingQuestions);
                } else {
                    System.exit(0);
                }
            } else if ((i >= 5) && (i < 10)) {
                System.out.println("The answer was incorrect! You go home with 1000 EUR!");
                System.out.println();
                System.out.printf("Do you want to play again?");
                String playAgain = scanner.next();
                System.out.println();
                if (playAgain.equalsIgnoreCase("yes")) {
                    LibraryOfQuestions.createPlayingQuestions();
                    playAgain(LibraryOfQuestions.randomPlayingQuestions);
                } else {
                    System.exit(0);
                }
            } else if (i > 10) {
                System.out.println("The answer was incorrect! You go home with 32000 EUR!");
                System.out.println();
                System.out.printf("Do you want to play again?");
                String playAgain = scanner.next();
                System.out.println();
                if (playAgain.equalsIgnoreCase("yes")) {
                    LibraryOfQuestions.createPlayingQuestions();
                    playAgain(LibraryOfQuestions.randomPlayingQuestions);
                } else {
                    System.exit(0);
                }
            }
        }
    }

    public static void helpPlayer( Question question ) {
        System.out.println();
        ArrayList<String> answerList = new ArrayList<>();
        answerList.add(question.answerA);
        answerList.add(question.answerB);
        answerList.add(question.answerC);
        answerList.add(question.answerD);
        String tempValue = "";
        for (int i = 0; i < answerList.size(); i++) {
            String answerLetter = answerList.get(i).substring(0, 1);
            if (answerLetter.equalsIgnoreCase(question.answerCorrect)) {
                tempValue = answerList.get(i);
                answerList.remove(answerList.get(i));
            }

        }
        for (int i = 0; i < 2; i++) {
            int position = (int) ((Math.random() * answerList.size()));
            answerList.remove(position);
        }
        answerList.add(tempValue);
        helpTries--;
        System.out.println("You have " + helpTries + " help options left");
        System.out.println(question.questionAsked);
        for (String answer : answerList) {
            System.out.printf(answer + "    ");


        }
        System.out.println();

    }

    public static void playAgain( ArrayList<Question> questions ) {
        Game.startGame();
        System.out.println();
        Game.gameQuestions(questions);
    }
}

