package quiz.game;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {
        QuizServer quizServer;
        System.out.println("*".repeat(90));
        System.out.println("Server is running");
        System.out.println("*".repeat(90));
        try {
            LocateRegistry.createRegistry(1900);
            quizServer = new QuizServer(Integer.parseInt(args[0]));
            Naming.bind("rmi://localhost:1900/QuizService", quizServer);
            while(quizServer.getClients().size()< quizServer.getNbPlayers()){
                System.out.print("");
            }

            quizServer.broadCastQuestion();


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
