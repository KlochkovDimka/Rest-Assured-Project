package org.practiceThree.json;

import java.util.List;

public class JsonEntity {

    public String getJsonModule(Integer moduleId, List<Integer> arrayQuest) {
        return "{\n" +
                "    \"_id\": " + moduleId + ",\n" +
                "    \"questions\":" + arrayQuest.toString() + ",\n" +
                "}";
    }

    public String getJsonExam(Integer examId, List<Integer> listQuestsId) {
        return "{\n" +
                "    \"currentPotQuestions\":" + listQuestsId.toString() + ",\n" +
                "    \"_id\": " + examId + "\n" +
                "}";
    }
}
