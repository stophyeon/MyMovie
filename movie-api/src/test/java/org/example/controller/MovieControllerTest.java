package org.example.controller;

import io.micrometer.core.instrument.search.Search;
import org.example.dto.SearchRes;
import org.example.dto.SearchResList;
import org.example.service.MovieSearchAPI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    MovieSearchAPI movieSearchAPI;
    @Test
    @DisplayName("제목 검색 테스트")
    void search() throws Exception {
        SearchRes searchRes1 = SearchRes.builder().
            title("영화제목 1").build();
        SearchRes searchRes2 = SearchRes.builder().
                title("영화제목 2").build();
        SearchRes searchRes3 = SearchRes.builder().
                title("영화제목 3").build();
        SearchRes searchRes4 = SearchRes.builder().
                title("영화제목 4").build();
        List<SearchRes> lists = new ArrayList<>();
        lists.add(searchRes1);
        lists.add(searchRes2);
        lists.add(searchRes3);
        lists.add(searchRes4);
        SearchResList list = new SearchResList("1",lists);



    }

    @Test
    void detail() {
    }

    @Test
    void castDetail() {
    }
}