package com.example.service;

import com.example.model.Author;
import com.example.model.Book;
import com.example.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository = new BookRepository();

    public Book createBook(String title, Author author, int publicationYear) {
        Book book = new Book(title, author, publicationYear);
        bookRepository.addBook(book);
        logger.info("Создана книга: {}", book);
        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepository.findBooksByAuthor(authorName);
    }
}
