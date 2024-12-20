package com.example;

import com.example.config.AppConfig;
import com.example.model.Author;
import com.example.model.Book;
import com.example.service.AuthorService;
import com.example.service.BookService;
import com.example.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LibraryManagementApplication {
    private static final Logger logger = LoggerFactory.getLogger(LibraryManagementApplication.class);

    public static void main(String[] args) {
        try {
            System.out.println("Application starting...");
            logger.info("Запуск приложения управления библиотекой.");

            // Инициализация конфигурации
            System.out.println("Инициализация конфигурации...");
            AppConfig config = new AppConfig();

            // Создание сервисов
            System.out.println("Создание AuthorService...");
            AuthorService authorService = new AuthorService();
            System.out.println("Создание BookService...");
            BookService bookService = new BookService();

            // Создание авторов
            System.out.println("Создание авторов...");
            Author author1 = authorService.createAuthor("Джордж Оруэлл", "british");
            Author author2 = authorService.createAuthor("Маргарет Этвуд", "canadian");

            // Создание книг
            System.out.println("Создание книг...");
            Book book1 = bookService.createBook("1984", author1, 1949);
            Book book2 = bookService.createBook("Animal Farm", author1, 1945);
            Book book3 = bookService.createBook("The Handmaid's Tale", author2, 1985);

            // Получение списка всех книг
            System.out.println("Получение списка всех книг...");
            List<Book> books = bookService.getAllBooks();
            logger.info("Все книги: {}", books);

            // Сериализация книг в JSON
            System.out.println("Сериализация книг в JSON...");
            String booksJson = JsonUtil.serialize(books);
            logger.info("Сериализованные книги в JSON: {}", booksJson);

            // Десериализация книг из JSON
            System.out.println("Десериализация книг из JSON...");
            List<Book> deserializedBooks = JsonUtil.deserializeList(booksJson, Book.class);
            logger.info("Десериализованные книги: {}", deserializedBooks);

            logger.info("Приложение успешно завершило работу.");
            System.out.println("Application finished successfully.");
        } catch (Throwable t) { // Перехват всех типов ошибок и исключений
            System.out.println("Произошла ошибка:");
            t.printStackTrace();
        }
    }
}
