package quiz.game;

import java.rmi.Naming;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IQuizServer quizServer;
        try {
            quizServer = (IQuizServer) Naming.lookup("rmi://localhost:1900/QuizService");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez le pseudo");
            String playerName = scanner.nextLine();
            QuizClient client = new QuizClient(playerName, quizServer);
            quizServer.addPlayer(playerName, client);
            new Thread(client).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
