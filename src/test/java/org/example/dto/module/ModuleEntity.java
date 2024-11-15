package org.example.dto.module;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ModuleEntity {
    private String name;
    private List<Integer> questions;
}
