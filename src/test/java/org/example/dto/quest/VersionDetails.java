package org.example.dto.quest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VersionDetails {
    private Integer patch;
    private Integer subVersion;
    private Integer version;
    private String versionStr;
}
