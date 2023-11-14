package com.example.bookshelf.book;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookname;
    private String author;
    private int rating;

    //Constructor with no arguments
    public Book() {
    }

    //Constructor with arguments
    Book(String bookname, String author, int rating) {
        this.bookname = bookname;
        this.author = author;
        this.rating = rating;
    }

    // Setter and Getter methods

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
}
