package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SearchRes {
    private Long id;
    private String title;
    private String overview;
    private String poster_path;
    private Double vote_average;
    @Builder
    public SearchRes(Long id, String title, String overview, String poster_path, Double vote_average) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
    }
}
