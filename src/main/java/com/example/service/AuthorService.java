package com.example.service;

import com.example.model.Author;
import com.example.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AuthorService {
    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);
    private final AuthorRepository authorRepository = new AuthorRepository();

    public Author createAuthor(String name, String nationality) {
        Author author = new Author(name, nationality);
        authorRepository.addAuthor(author);
        logger.info("Создан автор: {}", author);
        return author;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findAuthorByName(name);
    }
}
