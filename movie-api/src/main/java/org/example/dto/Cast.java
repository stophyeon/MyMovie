package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Cast {

    private Long cast_id;

    private String name;
    @JsonProperty("known_for_department")
    private String department;
    private String profile_path;
    private String character;
    private String biography;
    @JsonProperty("known_for")
    private List<SearchRes> movies;

    @Builder
    public Cast(Long cast_id,String biography, String name, String profile_path, String character) {
        this.cast_id = cast_id;
        this.name = name;
        this.profile_path = profile_path;
        this.character = character;
        this.biography=biography;
    }

}