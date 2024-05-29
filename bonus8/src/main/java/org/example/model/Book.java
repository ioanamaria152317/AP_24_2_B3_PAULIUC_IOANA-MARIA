package org.example.model;

import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String title;
    private List<Author> authors = new ArrayList<>();
    private int numberOfPages;
    private Date publicationDate;
    private boolean isRelated = false;
    public Book(String title, int numberOfPages, Date publicationDate){
        this.title=title;
        this.numberOfPages=numberOfPages;
        this.publicationDate=publicationDate;
    }

    public boolean isRelated(Book book){
        for(Author author1 : this.getAuthors()){
            for(Author author : book.getAuthors()) {
                if (author.equals(author1)) {
                    isRelated = true;
                    break;
                }
            }
        }
//        if (this.getAuthors().equals(book.getAuthors())){
//            isRelated=true;
//        }
        return isRelated;
    }

    public Book(int id, String title,List<Author> authorList, int numberOfPages, Date publicationDate){
        this.id=id;
        this.title=title;
        this.numberOfPages=numberOfPages;
        this.publicationDate=publicationDate;
        this.setAuthors(authorList);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors.stream().map(Author::getName).collect(Collectors.toList()) +
                ", numberOfPages=" + numberOfPages +
                ", publicationDate=" + publicationDate +
                ", isRelated=" + isRelated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && numberOfPages == book.numberOfPages && isRelated == book.isRelated && Objects.equals(title, book.title) && Objects.equals(authors, book.authors) && Objects.equals(publicationDate, book.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, numberOfPages, publicationDate, isRelated);
    }
}
