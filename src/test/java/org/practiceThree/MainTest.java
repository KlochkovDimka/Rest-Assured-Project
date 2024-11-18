package org.practiceThree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.bson.Document;
import org.example.dto.users.CustomData;
import org.example.dto.users.NewUserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.practiceThree.config.ConnectAPI;
import org.practiceThree.json.JsonEntity;
import org.practiceThree.listener.Listener;

import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

@ExtendWith(Listener.class)
public class MainTest <T> extends ConnectAPI {
    private final Faker faker = new Faker();
    private final JsonEntity json = new JsonEntity();
    private int questId;


    //1+
    @Test
    @DisplayName("Добавление уже существующего пользователя")
    public void addExistingUser() {
        String jsonSchemaPath = "jsonSchemes/usersSchema.json";
        NewUserRequest userRequest = new NewUserRequest(
                new CustomData(true, "2024-08-25T19:01:00.000Z", "on_project"),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.name().firstName(),
                faker.internet().password(),
                "admin");

        given()
                .spec(request.getRequest(token, userRequest))
                .when()
                .post("/user-auth1");

        given()
                .spec(request.getRequest(token, userRequest))
                .when()
                .post("/user-auth1")
                .then()
                .statusCode(400);
    }

    //2+
    @Test
    @DisplayName("Добавление ответа к вопросу")
    public void AddResponseByQuest() {
        String jsonSchemaPath = "jsonSchemes/UpdataQuestSchema.json";

        String jsonBody = "{\"name\":\"" + faker.bothify("????????? ??????????") + "\"}";
        String questName;
        String responseName = "оп оп оп";

        Response createdQuest = given()
                .spec(request.getRequest(token, jsonBody))
                .when()
                .post("/theme-question");

        questId = createdQuest.body().jsonPath().getInt("data._id");
        questName = createdQuest.body().jsonPath().getString("data.name");

        Response nowResponse = given()
                .spec(request.getRequest(token, setEntity
                        .findUpdateQuestAddResponse(questId, responseName, questName)))
                .when()
                .post("/create-lts");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        Document document = mongodb.findUpdateQuest(questId);

        assertEquals(document.get("answer"), "оп оп оп");
    }
    //3 +
    @Test
    @DisplayName("Добавление в модуль не существующего вопроса")
    public void AddFailIdQuestInModule() throws JsonProcessingException {
        String URI = "/course-module?search=&per_page=50&page=1&sort=_id" +
                "&direction=desc&sub_id=&filters%5B0%5D=name&filters%5B1%5D=_id";
        int moduleId;
        List<Integer> arrayQuest;

        Response getAllModule = given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .when()
                .get(URI);

        LinkedHashMap<String, T> list = getAllModule.body().jsonPath().getJsonObject("data.items[0]");
        moduleId = (int) list.get("_id");
        arrayQuest = (List<Integer>) list.get("questions");
        arrayQuest.add(1235);

        Response nowResponse = given()
                .baseUri("https://aqa-api.javacode.ru/api")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(json.getJsonModule(moduleId, arrayQuest))
                .when()
                .log().all()
                .put("/course-module");
        System.out.println(nowResponse.body().asPrettyString());
        nowResponse.then()
                .statusCode(400);
    }
    //4
    @Test
    @DisplayName("Добавление вопроса в экзамен")
    public void addQuestInExam() {
        String jsonSchemaPath = "jsonSchemes/examSchema.json";
        int id = 1004;
        List<Integer> questsId = List.of(1030, 1032);
        Response nowResponse = given()
                .spec(request.getRequest(token, json.getJsonExam(id, questsId)))
                .when()
                .put("/exam");

        nowResponse
                .then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        String jso = nowResponse.body().jsonPath().toString();
        System.out.println(jso);
    }
    //5+
    @ParameterizedTest
    @CsvFileSource(resources = "updateExamData.csv")
    @DisplayName("Изменения экзамена не валидными данными времени")
    public void addUpdateExam(String date) {
        String json = "{\n" +
                "    \"cd\": \""+ date+"\",\n" +
                "    \"_id\": 1004\n" +
                "}";
        Response nowResponse = given()
                .spec(request.getRequest(token, json))
                .when()
                .put("/exam");

        nowResponse
                .then()
                .log().all()
                .statusCode(400);

        String jso = nowResponse.body().jsonPath().toString();
        System.out.println(jso);
    }

}
