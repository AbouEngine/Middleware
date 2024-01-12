package quiz.game;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QuizServer extends UnicastRemoteObject implements IQuizServer {
    private final List<Question> questions;
    private Map<String, Integer> players;
    private List<IQuizClient> clients;
    private int currentQuestionIndex = 0;
    private boolean buzzer = false;
    private final Lock buzzerLock = new ReentrantLock();
    private int readyPlayers = 0;
    private boolean display = true;
    private final int nbPlayers;
    private String message;




    protected QuizServer(int nbPlayers) throws RemoteException {
        super();
        questions = QuizData.getData();
        players = new HashMap<>();
        Collections.shuffle(questions);
        clients = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        this.nbPlayers = nbPlayers;
    }
    public synchronized void addPlayer(String playerName, IQuizClient quizClient) throws RemoteException{
        players.put(playerName,0);
        clients.add(quizClient);

    }

    protected void broadCastQuestion() throws RemoteException {
        buzzer = false;
        readyPlayers = 0;
        currentQuestionIndex++;
        for (IQuizClient client : clients){
            client.receiveQuestion(questions.get(currentQuestionIndex));
        }
        display = true;
    }


    @Override
    public boolean isGameFinished() throws RemoteException {
        Optional<Integer> max = players.values().stream().max(Integer::compare);
        return (max.isPresent() && max.get() >= 10) || currentQuestionIndex > questions.size();
    }

    @Override
    public boolean displayNextQuestion() throws RemoteException {
        return display;
    }

    @Override
    public  void  submitAnswer(String playerName, int answer) throws RemoteException {
        display = false;
        buzzerLock.lock();
        try{
            if(!buzzer){
                buzzer = true;
                int playerScore = players.get(playerName);

                if(questions.get(currentQuestionIndex).getCorrectAnswer() == answer ){
                    players.put(playerName, ++playerScore);
                    message = String.format("Le joueur %s a appuye sur le buzzer et a donne la bonne reponse (+1)"
                            , playerName);
                }
                else{
                    players.put(playerName, --playerScore);
                    message = String.format("Le joueur %s a appuye sur le buzzer et a donne une mauvaise reponse (-1)",
                            playerName);
                }


            }
            readyPlayers++;
            if(readyPlayers == clients.size()){
                broadCastQuestion();
            }

        }finally {
            buzzerLock.unlock();
        }

        if(isGameFinished()) System.out.printf("Le joueur %s est le gagnant", getWinner());

    }


    @Override
    public String getWinner() throws RemoteException {

        Optional<Map.Entry<String, Integer>> maxEntry = players.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        return maxEntry.map(Map.Entry::getKey).orElse("");

    }

    public List<IQuizClient> getClients() {
        return clients;
    }

    @Override
    public Map<String, Integer> getScores() throws RemoteException {
        return players;
    }

    public int getNbPlayers(){
        return nbPlayers;
    }

    @Override
    public String getMessage() throws RemoteException {
        return message;
    }
}

