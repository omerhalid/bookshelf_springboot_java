package com.example.bookshelf.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshelf.book.OpenLibraryService.OpenLibraryResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    private final OpenLibraryService openLibraryService;

    @Autowired
    BookController(BookService bookService, OpenLibraryService openLibraryService) {
        this.bookService = bookService;
        this.openLibraryService = openLibraryService;
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

    @RequestMapping("/search")
    public OpenLibraryResponse searchBooks(@RequestParam String title) {
        title = title.replace(" ", "+");
        return openLibraryService.searchBook(title);
    }

    @RequestMapping("/is-present")
    public void isBookPresent(@RequestParam String title) {
        if(openLibraryService.isBookPresent(title)){
            System.out.println("Book is present");
        } else {
            System.out.println("Book is not present");
        }
    }
}
