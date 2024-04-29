package com.example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Value("${omdb.apikey}")
    private String apiKey;

    @Value("${omdb.apiUrl}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovieDetails(String title) {
        String url = apiUrl.replace("{apiKey}", apiKey).replace("{title}", title);
        return restTemplate.getForObject(url, Movie.class);
    }
}


