package org.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MovieDetailDto {
    private SearchRes movie;
    private CastList castList;

    public MovieDetailDto(SearchRes movie, CastList castList) {
        this.castList = castList;
        this.movie =movie;
    }
}
