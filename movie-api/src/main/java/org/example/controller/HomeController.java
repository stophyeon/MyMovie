package org.example.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.SearchReq;
import org.example.dto.SearchRes;
import org.example.dto.SearchResList;
import org.example.service.MovieSearchAPI;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class HomeController {
    private final MovieSearchAPI movieSearchAPI;


    public HomeController(MovieSearchAPI movieSearchAPI) {
        this.movieSearchAPI = movieSearchAPI;

    }
    @GetMapping("")
    public List<SearchRes> index() throws IOException, ParseException {
        SearchResList popularMovies = movieSearchAPI.popularMovie();

        return popularMovies.getResults();
    }
    @PostMapping("/genre")
    public List<SearchRes> searchGenre(@RequestBody SearchReq req) throws ParseException, JsonProcessingException {

        SearchResList genreMovies = movieSearchAPI.searchMovieByGenre(req.getGenre());

        return genreMovies.getResults();

    }
}
