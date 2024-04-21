package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

@Data
@NoArgsConstructor
public class Bag {
    private final List<Tile> tiles=new ArrayList<>();
    private int limit;
    public Bag(int n){
        limit=n;
        for (int i=1;i<=n;i++){
           for(int j=i+1;j<=n;j++){
               if (i!=j){
                   tiles.add(new Tile(i,j));
               }
           }
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {  //jetoane extrase de catre toti jucatorii
        Random random=new Random();
        List<Tile> extracted = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            int randomRandom= random.nextInt(tiles.size());
            extracted.add(tiles.get(randomRandom));
            tiles.remove(tiles.get(randomRandom));
        }
        return extracted;
    }
}
