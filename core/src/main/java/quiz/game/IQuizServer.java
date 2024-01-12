package quiz.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IQuizServer extends Remote {

    void submitAnswer(String playerName, int answer) throws RemoteException;
    boolean displayNextQuestion() throws RemoteException;
    boolean isGameFinished() throws RemoteException;
    void addPlayer(String playerName, IQuizClient quizClient) throws RemoteException;

    Map<String, Integer> getScores() throws RemoteException;
    String getWinner() throws RemoteException;
    String getMessage() throws RemoteException;

}
