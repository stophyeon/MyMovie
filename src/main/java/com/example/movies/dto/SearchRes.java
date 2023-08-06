package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRes {


    private Long id;

    private String title;
    private String overview;
    private String poster_path;
    private Double vote_average;



}
