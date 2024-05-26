package com.example.lab11;

import com.example.lab11.Models.Author;
import com.example.lab11.Repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
        return args -> {
            Author author1 = new Author();
            author1.setName("John");
            Author author2 = new Author();
            author2.setName("Andrei");
            Author author3 = new Author();
            author3.setName("Ioana");

            authorRepository.saveAll(List.of(author1,author2,author3));
        };
    }
}
