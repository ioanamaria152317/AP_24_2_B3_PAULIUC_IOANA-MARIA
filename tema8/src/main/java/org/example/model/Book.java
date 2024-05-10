package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String title;
    private List<Author> authors;
    private int numberOfPages;
    private Date publicationDate;
    public Book(String title, int numberOfPages, Date publicationDate){
        this.title=title;
        this.numberOfPages=numberOfPages;
        this.publicationDate=publicationDate;
    }
}
