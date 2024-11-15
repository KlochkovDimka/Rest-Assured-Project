package org.example.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomData {
    private Boolean isCv;
    private String salesOpenTime;
    private String salesStatus;
}
