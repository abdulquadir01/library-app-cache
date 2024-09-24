package dev.aq.cache.library.service;

import dev.aq.cache.library.model.Book;

import java.util.List;

public interface BookService  {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(long id);

    List<Book> getBooks();

    String deleteBook(long id);
}
