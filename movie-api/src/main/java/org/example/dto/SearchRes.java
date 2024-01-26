package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SearchRes {
    private Long id;
    private String title;
    private String overview;
    private String poster_path;
    private Double vote_average;
    private String release_date;
    private Long runtime;
    @JsonProperty("backdrop_path")
    private String back_poster;

    @Builder
    public SearchRes(Long id, String title, String overview, String poster_path, Double vote_average,Long runtime, String release_date,String back_poster) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
        this.runtime=runtime;
        this.release_date=release_date;
        this.back_poster=back_poster;
    }
}
