package com.example.bookshelf.book;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenLibraryService {

    private final RestTemplate restTemplate;

    public OpenLibraryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OpenLibraryResponse searchBook(String title){
        String url = "https://openlibrary.org/search.json?title=" + title.replace(" ", "+");
        return restTemplate.getForObject(url, OpenLibraryResponse.class);
    }

    public Boolean isBookPresent(String title){
        OpenLibraryResponse response = searchBook(title);
        if(response != null && response.getNumFound() > 0) {
            return true;
        }
        return false;
    }

    public static class OpenLibraryResponse {
        private int numFound;

        public int getNumFound() {
            return numFound;
        }

        public void setNumFound(int numFound) {
            this.numFound = numFound;
        }
    }
    
}
