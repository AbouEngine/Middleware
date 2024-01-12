package quiz.game;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IQuizClient extends Remote {
    void receiveQuestion(Question question) throws RemoteException;

}
