package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}


