package org.example.config;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.generet.SetEntity;
import org.example.db.ConnectionMongodb;
import org.example.dto.users.UserAuthentication;
import org.example.specification.SpecificationRequest;
import org.example.specification.SpecificationResponse;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class ConnectAPI {

    private final String login = "klochkov_dmitriy";
    private final String password = "WX${6vY_VQ[Is";
    protected UserAuthentication user;
    protected SpecificationRequest request;
    protected SpecificationResponse response;
    protected ConnectionMongodb mongodb;
    protected String token;
    protected SetEntity setEntity;


    @BeforeMethod
    public void setUp() {
        request = new SpecificationRequest();
        response = new SpecificationResponse();
        user = new UserAuthentication(login, password);
        mongodb = new ConnectionMongodb();
        setEntity = new SetEntity();
    }

    @AfterMethod
    public void tearDown() {
        refreshToken();
    }

    private void refreshToken() {
        Response response = RestAssured
                .given()
                .spec(request.getRequestNoAuthentication(setEntity.findUserAuthentication(login, password)))
                .when()
                .post("/auth/login");

        token = response.jsonPath().getString("token");
    }

    public String getLogin() {
        return login;
    }
}
