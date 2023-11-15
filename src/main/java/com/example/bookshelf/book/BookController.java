package com.example.bookshelf.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    //(so it needs to be back to @RequstMapping)
    @PostMapping("/search")  
    public String searchBooks(@RequestBody Map<String, String> body) { //change this back to @RequestParam. 
        String title = body.get("title");
        return openLibraryService.searchBook(title);
    }
}
