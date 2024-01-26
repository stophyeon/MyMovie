package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@RequiredArgsConstructor
public class SearchReq {
    String query;
    String genre;
    String id;
    @JsonProperty("cast_id")
    String castId;
}
