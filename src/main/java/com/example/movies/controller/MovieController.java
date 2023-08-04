package com.example.movies.controller;

import org.springframework.ui.Model;
import com.example.movies.dto.SearchReq;
import com.example.movies.dto.SearchRes;
import com.example.movies.service.MovieSearchAPI;
import com.example.movies.service.MovieService;
import com.example.movies.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieSearchAPI movieSearchAPI;
    private final MovieService movieService;
    private final UserService userService;
    @PostMapping("/movie/search")
    public String search(SearchReq searchReq, Model model) throws IOException, ParseException{
        List<SearchRes> movies = movieSearchAPI.searchMovie(searchReq);
        model.addAttribute("movies",movies);
        return "movies";
    }

}
