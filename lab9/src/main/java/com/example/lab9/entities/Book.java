package com.example.lab9.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="book", schema="public")
@NamedQueries({
        @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :myId"),
        @NamedQuery(name = "Book.findLikeTitle", query = "SELECT b FROM Book b WHERE b.title LIKE CONCAT('%', :title,'%')")
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="numberofpages")
    private int numberOfPages;

    @Column(name="publicationdate")
    private Date publicationDate;
}
