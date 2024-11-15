package org.example.dto.quest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DataEntity {
    private String jsDetails;
    private String comment;
    private List<Object> quizes;
    private List<Object> hints;
    private String type;
    private List<Object> videos;
    private String name;
    private List<Object> hashTags;
    private String title;
    private String answer;
    private List<Fact> facts;
    private List<UseCase> useCases;
    private String originalDuplicateId;
    private Integer questionId;
}
