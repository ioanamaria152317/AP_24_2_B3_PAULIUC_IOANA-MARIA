package org.example;

import org.example.model.Author;
import org.example.model.Book;
import org.example.repository.BookRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BookRepository repo = new BookRepository();
            Author author1 = new Author();
            author1.setName("Dostoievski");
            List<Author> authors = new ArrayList<>();
            authors.add(author1);
            Date date =  Date.valueOf("2003-07-15");
            Book book1 = new Book( "Crima si pedeapsa",  650, date);
            repo.create(book1);
            Book book2 = new Book( "Fratii Karamazov",  800, date);
            repo.create(book2);
        } catch (SQLException e) {
            System.err.println("Offffffffffff iar am eroare" + e);
        }
    }
}


//de ce cu static nu merge sa apelez create in main --------e doar acolo