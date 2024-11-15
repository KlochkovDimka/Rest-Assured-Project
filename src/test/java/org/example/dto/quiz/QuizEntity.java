package org.example.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class QuizEntity {
    private String answerType;
    private Boolean isValid;
    private String name;
    private List<Object> files;
    private List<Variation> variations;
}
