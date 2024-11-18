package org.practiceThree.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class QuestResponse {
    @JsonProperty("_id")
    private Integer id;
    private String name;
    private Integer quizExamSize;
    private Integer user;
    private List<Integer> blocks;
    private List<Integer> questions;
    private List<Integer> quizes;
    private String cd;
}
