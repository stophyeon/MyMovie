package org.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SearchResList {
    private String page;
    private List<SearchRes> results;
}
