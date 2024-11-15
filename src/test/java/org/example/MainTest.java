package org.example;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.example.config.ConnectAPI;
import org.example.dto.users.NewUserRequest;
import org.example.dto.users.UserAuthentication;
import org.example.generet.GeneratorUserEntity;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.AssertJUnit.assertEquals;

@Slf4j
public class MainTest extends ConnectAPI {
    private String questId;
    private GeneratorUserEntity generatorUserEntity = new GeneratorUserEntity();
    private String moduleName;
    private Integer moduleId;
    private Integer courseId;
    private Integer examId;

    //1 +
    @Test
    public void authenticationTest() {

        String jsonSchemaPath = "userResponseAuthentication.json";

        Response nowResponse = given()
                .spec(request.getRequestNoAuthentication(user))
                .when()
                .post("/auth/login");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath))
                .extract().body().asPrettyString();

        token = nowResponse
                .jsonPath()
                .getString("token");

        Document document = mongodb.findEntity(getLogin());
        Integer id = (Integer) document.get("_id");

        assertEquals(document.get("username"), getLogin());
        assertEquals(document.get("_id"), id);
    }

    //2
    @Test(priority = 1, dataProvider = "createNewUser", dataProviderClass = MainTest.class, enabled = false)
    public void createUsers(NewUserRequest userRequest) {
        String jsonSchemaPath = "usersSchema.json";

        Response nowResponse = given()
                .spec(request.getRequest(token, userRequest))
                .when()
                .post("/user-auth1");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        String id = nowResponse
                .jsonPath()
                .getString("data._id");

        Document document = mongodb.findEntityBuId(id);

        assertEquals(document.get("username"), getLogin());
        assertEquals(document.get("_id"), id);
    }

    //3 +
    @Test(priority = 2, enabled = false)
    public void createdQuested() {
        String jsonSchemaPath = "questSchema.json";
        String jsonBody = "{\"name\":\"Какое масло залить в форда, чтобы он его не сожрал за 3 месяца???\"}";
        Response nowResponse = given()
                .spec(request.getRequest(token, jsonBody))
                .when()
                .post("/theme-question");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        questId = nowResponse
                .jsonPath()
                .getString("data._id");

        Document document = mongodb.findQuest(questId);

        assertEquals(document.get("name"), "Какое масло залить в форда, чтобы он его не сожрал за 3 месяца???");
    }

    //4 +
    @Test(priority = 3, enabled = false)
    public void updateQuested() {
        String jsonSchemaPath = "UpdataQuestSchema.json";
        String newNameQuest = "Этот крокодил любое сожрет";
        Response nowResponse = given()
                .spec(request.getRequest(token, setEntity
                        .findUpdateQuest(Integer.parseInt(questId), newNameQuest)))
                .when()
                .post("/create-lts");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        Document document = mongodb.findUpdateQuest(questId);

        assertEquals(document.get("name"), newNameQuest);
    }

    //5+
    @Test(priority = 4, enabled = false)
    public void createdQuiz() {
        String jsonSchemaPath = "quizeSchema.json";
        String nameQuiz = "Вопрос на засыпку";

        given()
                .spec(request.getRequest(token,
                        setEntity.findQuiz(nameQuiz)))
                .when()
                .post("/quiz")
                .then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        Document document = mongodb.findQuiz(nameQuiz);

        assertEquals(document.get("name"), nameQuiz);
    }

    //6+
    @Test(priority = 4, enabled = false)
    public void createNewModule() {
        String jsonSchemaPath = "moduleSchema.json";
        moduleName = "Я в своем познании на столько приспел...";
        Response nowResponse = given()
                .spec(request.getRequest(token, setEntity.findModule(moduleName)))
                .when()
                .post("/course-module");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        moduleId = Integer.parseInt(nowResponse
                .jsonPath()
                .getString("data._id"));

        Document document = mongodb.findModule(moduleId);

        assertEquals(document.get("name"), moduleName);
    }

    //7+
    @Test(priority = 5, enabled = false)
    public void createNewCourse() {
        String jsonSchemaPath = "courseSchema.json";
        String courseName = "Curse";

        Response nowResponse = given()
                .spec(request.getRequest(token, setEntity.findCurse(courseName, moduleName, moduleId)))
                .when()
                .post("/course");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        courseId = Integer.parseInt(nowResponse
                .jsonPath()
                .getString("data._id"));

        Document document = mongodb.findCourse(courseId);

        List<Document> documents = (List<Document>) document.get("modules");

        Optional<Object> moduleNameFromMongoDB = documents.stream()
                .map(x -> x.get("name"))
                .findFirst();
        Optional<Object> moduleIdFromMongoDB = documents.stream()
                .map(x -> x.get("module"))
                .findFirst();

        assertEquals(document.get("name"), courseName);
        assertEquals(moduleNameFromMongoDB.get(), moduleName);
        assertEquals(moduleIdFromMongoDB.get(), moduleId);
    }

    //8+
    @Test(priority = 5, enabled = false)
    public void createNewExam() {
        String jsonSchemaPath = "examSchema.json";
        String examName = "EXAM";
        Response nowResponse = given()
                .spec(request.getRequest(token, setEntity.findExam(examName)))
                .when()
                .post("/exam");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        examId = Integer.parseInt(nowResponse.jsonPath().getString("data._id"));

        Document document = mongodb.findExam(examName);

        assertEquals(document.get("name"), examName);
    }

    //9
    @Test(priority = 5, enabled = false)
    public void createNewTemplate() {
        String jsonSchemaPath = "quizeSchema.json";
        String name = "Grand Theft Auto";
        Response nowResponse = given()
                .spec(request.getRequest(token, setEntity.findTemplate(name, examId, courseId)))
                .when()
                .post("/user-hr-template");

        nowResponse.then()
                .spec(response.getSpecResponse(jsonSchemaPath));

        int templateId = Integer.parseInt(nowResponse.jsonPath().getString("data._id"));

        Document document = mongodb.findTemplate(templateId);

        assertEquals(document.get("name"), name);
    }

    //10
    @Test()
    public void authenticationFailTest() {

        String jsonSchemaPath = "errorSchema.json";
        Faker faker = new Faker();
        Response nowResponse = given()
                .spec(request.getRequestNoAuthentication(
                        new UserAuthentication(faker.internet().emailAddress(),faker.internet().password())))
                .when()
                .post("/send-meters-by-seconds");

        nowResponse.then()
                .statusCode(400)
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .extract().body().asPrettyString();

    }

    @DataProvider(name = "createNewUser")
    private Object[][] newUsers() {
        return generatorUserEntity.findNewUserRequest();
    }
}