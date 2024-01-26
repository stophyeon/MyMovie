package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieSearchAPITest {
    @Autowired
    MovieSearchAPI movieSearchAPI;
    @Test
    void searchMovie() throws IOException, ParseException {
        System.out.println(movieSearchAPI.searchMovie("아이언맨").getResults().get(0).getPoster_path());
        System.out.println(movieSearchAPI.searchMovie("아이언맨").getResults().get(0).getBack_poster());
        System.out.println(movieSearchAPI.searchMovie("아이언맨").getResults().get(0).getTitle());
        System.out.println(movieSearchAPI.searchMovie("아이언맨").getResults().get(0).getVote_average());

    }

    @Test
    void searchMovieById() throws IOException, ParseException {
        System.out.println(movieSearchAPI.searchMovieById("10138").getBack_poster());
    }

    @Test
    void popularMovie() throws ParseException, IOException {
        System.out.println(movieSearchAPI.popularMovie());
    }

    @Test
    void searchMovieByGenre() throws ParseException, JsonProcessingException {
        System.out.println(movieSearchAPI.searchMovieByGenre("28"));
    }
}