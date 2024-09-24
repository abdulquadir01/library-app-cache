package dev.aq.cache.library.controller;

import dev.aq.cache.library.dto.BookRequest;
import dev.aq.cache.library.dto.BookResponse;
import dev.aq.cache.library.model.Book;
import dev.aq.cache.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable long id){
        Book fetchedBook = bookService.getBook(id);
        return mapper.map(fetchedBook, BookResponse.class);
    }

    @GetMapping()
    public List<BookResponse> getBooks(){
        List<Book> allFetchedBooks = bookService.getBooks();
        return allFetchedBooks
                    .stream()
                    .map(book -> mapper.map(book, BookResponse.class))
                    .toList();
    }

    @PostMapping()
    public BookResponse addBook(@RequestBody BookRequest bookRequest){
        Book bookToBeSaved = mapper.map(bookRequest, Book.class);
        Book response = bookService.addBook(bookToBeSaved);
        return mapper.map(response, BookResponse.class);
    }

    @PutMapping()
    public BookResponse updateBook(@RequestBody BookRequest book) {
        Book bookToBeUpdated = mapper.map(book, Book.class);
        Book response = bookService.addBook(bookToBeUpdated);
        return mapper.map(response, BookResponse.class);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable long id){
        return bookService.deleteBook(id);
    }

}
