package quiz.game;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Scanner;

public class QuizClient extends UnicastRemoteObject implements Runnable,IQuizClient, Serializable {
    private final IQuizServer quizServer;
    private final String playerName;
    private Question currentQuestion;

    private Map<String, Integer> scores;


    public QuizClient(String playerName, IQuizServer quizServer) throws RemoteException {
        super();
        this.playerName = playerName;
        this.quizServer = quizServer;
    }
    @Override
    public  void receiveQuestion(Question question) throws RemoteException {
        this.currentQuestion = question;

    }


    private void displayScores() throws RemoteException {

        System.out.println("+----------------------+");
        System.out.println("|      Scores          |");
        System.out.println("+----------------------+");


        for (Map.Entry<String, Integer> entry : quizServer.getScores().entrySet()) {
            String joueur = entry.getKey();
            String points = entry.getValue().toString();
            System.out.printf("| %-8s | %-8s |\n", joueur, points);
        }

        System.out.println("+----------------------+");
        System.out.println(quizServer.getMessage());
        System.out.println();
    }


    @Override
    public void run() {
        try{
            Scanner scanner = new Scanner(System.in);
            while (!quizServer.isGameFinished()){
                if (quizServer.displayNextQuestion() && currentQuestion != null) {
                    System.out.println("_".repeat(90));
                    System.out.println("Question: " + currentQuestion.getQuestion());
                    String[] options = currentQuestion.getOptions();
                    for (int i = 0; i < options.length; i++) {
                        System.out.println((i + 1) + ". " + options[i]);
                    }

                    System.out.println("Votre reponse (1-4): ");
                    int answer = scanner.nextInt();
                    quizServer.submitAnswer(playerName, answer);
                    displayScores();

                }
            }
            System.out.println("_".repeat(90));
            System.out.printf("Le joueur %s est le gagnant", quizServer.getWinner());



        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

