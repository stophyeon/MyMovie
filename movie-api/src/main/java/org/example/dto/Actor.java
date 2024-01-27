package org.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Actor {
    private List<Cast> results;
}
