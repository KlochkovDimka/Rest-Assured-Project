package org.example.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Variation {
    private String name;
    private Boolean isCorrect;
}
