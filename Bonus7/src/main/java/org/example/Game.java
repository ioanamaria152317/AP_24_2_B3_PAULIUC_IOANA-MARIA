package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class Game {
    private final Bag bag = new Bag(5);
    private final List<Player> players = new ArrayList<>();
    //un index pt fiecare jucator
    private int playerTurn=0;
    private boolean winnerFound = false;
   // private boolean hasCycle;
    private boolean gameRunning=true;
    private long startThread;
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() throws InterruptedException {
        List<Thread> playerThreads = new ArrayList<>();

        for (Player player : players) {
            Thread playerThread = new Thread(player);
            playerThreads.add(playerThread);
            playerThread.start();
        }

        Thread timekeeper = new Thread(() -> {
            startThread = System.currentTimeMillis();
            long timeLimit = 2000;

            try {
                while (System.currentTimeMillis() - startThread < timeLimit && !winnerFound && !getBag().getTiles().isEmpty()) {
                    Thread.sleep(100);
                    timeLimit -= 100;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this.getBag()) {
                this.getBag().getTiles().clear();    //golesc sacul cand jocul se termina
            }

            if(timeLimit >= System.currentTimeMillis()-startThread) {
                System.out.println("Time has passed!");
                players.forEach(player -> player.setRunning(false));
                gameRunning=false;
                long endTime = System.currentTimeMillis();
                long runningTime = endTime - startThread;
                System.out.println("Total running time: " + runningTime + "  milliseconds");
            }
        });
        timekeeper.setDaemon(true);
        timekeeper.start();

        for (Thread playerThread : playerThreads) {
            playerThread.join();
        }

        for (Player player : players) {
          /*  if (player.getTiles().size()==1)
                hasCycle=false;
            if( player.getTiles().size()>=2 && player.getTiles().getFirst().getNumberOne()==(player.getTiles().getLast().getNumberOne())
                    && player.getTiles().get(1).getNumberOne()==player.getTiles().getFirst().getNumberTwo()
                    && player.getTiles().get(player.getTiles().size()-2).getNumberTwo()==
                    player.getTiles().getLast().getNumberTwo() ){
                hasCycle=true;
            }*/
            System.out.println(player.getName() + " has picked: " + player.getTiles());
            System.out.println(" My sequence is: "+ player.getSequence() );
            //System.out.println(" I have a cycle " + hasCycle);
            System.out.println(" Score: "+ player.getScore());
            System.out.println();
            if (!player.hasCycleH()){
                System.out.println(player.getName()+ " nu e smart, dar nu judeca");
            }
            else{
                System.out.println(player.getName()+ " e smart rau bravo lui");
            }
        }

        if (!winnerFound) {
            List<Player> sortedPlayers = players.stream()
                    .sorted(Comparator.comparing(Player::getScore).reversed()
                            .thenComparing(Player::getName))
                    .toList();
            System.out.println("The winner with most tiles is: " + sortedPlayers.get(0).getName());

            System.out.println(" Running time: ");
            System.out.println(System.currentTimeMillis()-startThread + "miliseconds");
        }
    }


    public static void main(String args[]) throws InterruptedException {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.addPlayer(new Player("Player 4"));
        // game.addPlayer(new Player("Player 5"));
        // System.out.println(game.getBag().getTiles().size());
        game.play();
        // System.out.println(game.isPlayerTurn(game.getPlayers().get(0)));
        // for (Player p: game.players)
        // System.out.println(game.getPlayers().indexOf(p));

    }

    public synchronized boolean isPlayerTurn(Player player) {
        return player.equals(players.get(playerTurn));
    }
    public synchronized void nextTurn(){
        this.playerTurn =(playerTurn+1)%players.size();   //creste prea mult daca de ex am 3 jucatori
    }

    public synchronized boolean isWinnerFound() {
        return winnerFound;
    }

    public synchronized void setWinnerFound(boolean winnerFound) {
        this.winnerFound = winnerFound;
    }
}


