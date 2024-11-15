package org.example.dto.quest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateQuest {
    private String currentLTS;
    private String changeKey;
    private Integer question;
    @JsonProperty("LTP")
    private LTP lTP;
    private VersionDetails versionDetails;
}
