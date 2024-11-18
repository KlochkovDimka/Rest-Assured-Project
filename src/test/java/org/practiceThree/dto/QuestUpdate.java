package org.practiceThree.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class QuestUpdate {
    @SerializedName("_id")
    private Integer id;
    private String name;
    private Integer quizExamSize;
    private Integer user;
    private List<Integer> blocks;
    private List<Integer> questions;
    private List<Integer> quizes;
    private String cd;
}
