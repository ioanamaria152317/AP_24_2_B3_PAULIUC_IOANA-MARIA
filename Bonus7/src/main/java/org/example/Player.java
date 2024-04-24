package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jgrapht.Graph;
import org.jgrapht.GraphTests;
import org.jgrapht.alg.tour.PalmerHamiltonianCycle;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = true;
    private List<Tile> tiles = new ArrayList<>();  //adica din cele extrase din bag
    //practic asta e secventa
    private int score;
    private List<Tile> sequence=new ArrayList<>();
    private boolean isSmart=false;
    public Player(String name) {
        this.name = name;
    }

    public void run() {
        while (running) {
            synchronized (game.getBag()) {
                while (!game.isPlayerTurn(this)) {
                    try {
                        System.out.println( this.name + " astept...");
                        game.getBag().wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Random random2=new Random();

                List<Tile> pickedTiles = game.getBag().extractTiles(random2.nextInt(1,5));

                tiles.addAll(pickedTiles);
                this.score = tiles.size();
                //System.out.println(name + " picked tiles: " + pickedTiles + " Score: " + score);

                if (game.getBag().getTiles().isEmpty()) {
                    this.running = false;
                    game.setGameRunning(false);
                }

                //   List<Integer> numbers = new ArrayList<>();
                int n = game.getBag().getLimit();

                for (Tile tile: tiles){
                    sequence=tiles.stream()
                            .sorted(Comparator.comparing(Tile::getNumberOne)
                                    .thenComparing(Tile::getNumberTwo))
                            .collect(Collectors.toList());
                }
                  /* for (int i = 1; i <= n; i++) {
                       numbers.add(i);
                   }*/

                  /* for(Tile tile : tiles) {
                       numbers.remove((Object)tile.getNumberOne());
                       numbers.remove((Object)tile.getNumberTwo());
                   }*/
                if(this.getTiles().size()==n) {
                    System.out.println("The winner isssss: suspanssssss " + this.name);
                    game.setWinnerFound(true);
                    for(Player player : game.getPlayers())
                        player.setRunning(false);
                    break;
                }

                game.nextTurn();
                game.getBag().notifyAll(); //trezeste celelalte fire de executie
            }
        }
    }
    public boolean hasCycleH(){
        Graph<Integer, DefaultEdge> graph =new SimpleGraph<>(DefaultEdge.class);
        for (Tile tile: tiles){
            graph.addVertex(tile.getNumberOne());   //da deci pun fiecare jeton in graful meu   ->ca o comp conexa
            graph.addVertex(tile.getNumberTwo());
            graph.addEdge(tile.getNumberOne(),tile.getNumberTwo());
        }
//oare e ok asa sau tbs a am ca muchie un jeton si dupa un alt graf in care conectez jetoane?//////// adica comp conexe??
        //vreau muchii
        if (tiles.size()>=2) {
            //MAI INTAI VREAU SA ADAUG MUCHIE INTRE ACELE JETOANE CARE AU UN NR COMUN
            for (int i = 0; i < tiles.size(); i++) {
                for (int j = i + 1; j < tiles.size(); j++) {
                    if (tiles.get(i).getNumberOne() == tiles.get(j).getNumberOne()) {
                        graph.addEdge(tiles.get(i).getNumberOne(), tiles.get(j).getNumberOne());
                    }
                    if (tiles.get(i).getNumberTwo() == tiles.get(j).getNumberOne()) {
                        graph.addEdge(tiles.get(i).getNumberTwo(), tiles.get(j).getNumberOne());
                    }
                    if (tiles.get(i).getNumberOne() == tiles.get(j).getNumberTwo()) {
                        graph.addEdge(tiles.get(i).getNumberOne(), tiles.get(j).getNumberTwo());
                    }
                    if (tiles.get(i).getNumberTwo() == tiles.get(j).getNumberTwo()) {
                        graph.addEdge(tiles.get(i).getNumberTwo(), tiles.get(j).getNumberTwo());
                    }
                }
            }
        }


       if (GraphTests.hasOreProperty(graph)){
            isSmart=true;
          // System.out.println(" My sequence now that i'm smart is: "+ new PalmerHamiltonianCycle<Tile,DefaultEdge>().getTour(graph));
            return true;
       }
       return false;
    }

}



