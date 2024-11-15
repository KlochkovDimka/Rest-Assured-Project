package org.example.dto.curse;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.dto.module.ModuleCurse;

import java.util.List;

@AllArgsConstructor
@Data
public class CurseEntity {
    private String name;
    private List<ModuleCurse> modules;
}
