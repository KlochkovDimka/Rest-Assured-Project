package org.practiceThree.config;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.db.ConnectionMongodb;
import org.example.dto.users.UserAuthentication;
import org.example.generet.SetEntity;
import org.example.specification.SpecificationRequest;
import org.example.specification.SpecificationResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.practiceThree.screenshot.Screenshot;

import static io.restassured.RestAssured.given;

public abstract class ConnectAPI {

    private final String login = "klochkov_dmitriy";
    private final String password = "WX${6vY_VQ[Is";
    protected UserAuthentication user;
    protected SpecificationRequest request;
    protected SpecificationResponse response;
    protected ConnectionMongodb mongodb;
    protected String token;
    protected SetEntity setEntity;
    private final Screenshot screenshot = new Screenshot();

    public ConnectAPI() {
        RestAssured.baseURI = "https://aqa-api.javacode.ru/api";
        request = new SpecificationRequest();
        response = new SpecificationResponse();
        user = new UserAuthentication(login, password);
        mongodb = new ConnectionMongodb();
        setEntity = new SetEntity();
    }

    @BeforeEach
    public void setUp() {
        Configuration.reportsFolder = "test-result/reports";
        String jsonSchemaPath = "jsonSchemes/userResponseAuthentication.json";
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
    }

    @AfterEach
    public void tearDown() {
        refreshToken();
    }

    protected void refreshToken() {
        Response response = RestAssured
                .given()
                .spec(request.getRequestNoAuthentication(setEntity.findUserAuthentication(login, password)))
                .when()
                .post("/auth/login");

        token = response.jsonPath().getString("token");
    }
}
