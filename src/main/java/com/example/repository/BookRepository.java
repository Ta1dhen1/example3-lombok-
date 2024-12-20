package com.example.repository;

import com.example.model.Book;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        logger.info("Добавление книги: {}", book);
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return ImmutableList.copyOf(books);
    }

    public List<Book> findBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return ImmutableList.copyOf(result);
    }
}
