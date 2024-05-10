package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor

public class Genre {
     private int id;
     private String name;
     private List<Book> books;
     public Genre(int id, String name){
          this.id=id;
          this.name=name;
     }
}
