package com.example.bookshelf.book;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenLibraryService {

    private final RestTemplate restTemplate;

    public OpenLibraryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String searchBook(String title){
        String url = "https://openlibrary.org/search.json?title=" + title.replace(" ", "+");
        return restTemplate.getForObject(url, String.class);
    }
    
}
