package com.example.bookshelf.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping
    List <Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
}
