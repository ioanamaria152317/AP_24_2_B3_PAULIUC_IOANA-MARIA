package com.example.lab11.Services;

import com.example.lab11.Models.Author;
import com.example.lab11.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository repo;

    @Autowired
    public AuthorService(AuthorRepository repo) {
        this.repo = repo;
    }

    public List<Author> getAuthors() {
        List<Author> authors = repo.findAll();
        return authors;
    }
}
