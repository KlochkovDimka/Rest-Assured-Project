package org.example.dto.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.dto.quiz.PotQuize;

import java.util.List;

@Data
@AllArgsConstructor
public class ExamEntity {
    private String name;
    private Integer minutesStr;
    private List<PotQuize> potQuizes;
}
