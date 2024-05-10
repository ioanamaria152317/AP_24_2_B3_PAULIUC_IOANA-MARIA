package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
   private int id;
   private String name;
   private List<Book> books;
   public Author(int id,String name){
      this.id=id;
      this.name=name;
   }
}
