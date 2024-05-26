package com.example.lab11.Controllers;

import com.example.lab11.Models.Author;
import com.example.lab11.Repositories.AuthorRepository;
import com.example.lab11.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/authors")
    public @ResponseBody List<Author> getAuthors() {
        return authorService.getAuthors();
    }
}
