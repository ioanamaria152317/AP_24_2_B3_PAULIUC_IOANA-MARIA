package com.example.lab9;

import com.example.lab9.entities.Author;
import com.example.lab9.entities.Book;
import com.example.lab9.repositories.AuthorRepository;
import com.example.lab9.repositories.BookRepository;
import com.example.lab9.repositories.GenreRepository;

public class Main {
    public static void main(String[] args) {

        BookRepository bookRepository=new BookRepository();
        AuthorRepository authorRepository=new AuthorRepository();
        GenreRepository genreRepository=new GenreRepository();

        Book book1=new Book();
        book1.setTitle("Strainul");
        bookRepository.save(book1);

        Author author1=new Author();
        author1.setName("Albert Camus");
        authorRepository.save(author1);
    }
}
