package com.example.repository;

import com.example.model.Author;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private static final Logger logger = LoggerFactory.getLogger(AuthorRepository.class);
    private final List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author) {
        logger.info("Добавление автора: {}", author);
        authors.add(author);
    }

    public List<Author> getAllAuthors() {
        return ImmutableList.copyOf(authors);
    }

    public Author findAuthorByName(String name) {
        return authors.stream()
                .filter(author -> author.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
