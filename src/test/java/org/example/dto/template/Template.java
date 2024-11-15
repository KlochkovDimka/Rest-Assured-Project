package org.example.dto.template;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Template {
    private String name;
    private String desc;
    private List<Exam> exams;
    private List<Course> courses;
}
