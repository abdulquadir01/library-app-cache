package dev.aq.cache.library.service;

import dev.aq.cache.library.model.Book;
import dev.aq.cache.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        log.info("adding book with id - {}", book.getId());
        return bookRepository.save(book);
    }

    @Override
    @CachePut(cacheNames = "books", key="#book.id")
    public Book updateBook(Book book) {
        bookRepository.updateAddress(book.getId(), book.getName());
        log.info("book updated with new name");
        return book;
    }

    @Override
    @Cacheable(cacheNames = "books", key="#id")
    public Book getBook(long id) {
        log.info("fetching book from db");
        Optional<Book> book = bookRepository.findById(id);
//        if (book.isPresent()) {
//            return book.get();
//        } else {
//            return new Book();
//        }
        return book.orElseGet(Book::new);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public String deleteBook(long id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }

}

