package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CastList {
    @JsonProperty("cast")
    private List<Cast> castList;
}
