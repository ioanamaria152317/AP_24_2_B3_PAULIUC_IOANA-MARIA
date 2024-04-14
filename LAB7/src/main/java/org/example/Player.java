package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Tile> tiles = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

//dc la all arg constr tb sa fac constr pt un sg arg?

    public void run() {
        while (running) {
            // pick one (or more?) tiles from the bag, if it’s my turn
            // think about how to make a sequence
            synchronized (game.getBag()) {
                while (!game.isPlayerTurn(this)) {
                    try {
                        game.getBag().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                List<Tile> pickedTiles = game.getBag().extractTiles(1);

                tiles.addAll(pickedTiles);
                System.out.println(name + " picked tiles: " + pickedTiles);

                game.notifyAll();
            }
        }
    }

}