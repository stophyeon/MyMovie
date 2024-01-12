package com.example.movies.service;

import com.example.movies.dto.SearchRes;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieSearchAPITest {
    @Autowired
    private MovieSearchAPI movieSearchAPI;
    @Test
    public void check() throws ParseException {
        List<SearchRes> movies =  movieSearchAPI.searchMovieByGenre("28");
        System.out.println(movies.get(1).getVote_average().getClass());



    }
}