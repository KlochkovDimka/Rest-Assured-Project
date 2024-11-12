package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.dto.UserAuthentication;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void authentication() {
        RestAssured.baseURI = "https://aqa-api.javacode.ru/api/auth/login";
        UserAuthentication user = new UserAuthentication("klochkov_dmitriy", "\\|WX${6vY_VQ[Is");

        JSONObject userReg = new JSONObject();
        userReg.put("username", "klochkov_dmitriy");
        userReg.put("password", "\\lWX${6vY_VQ[Is");

        Response response = RestAssured
                .given()
                .log().all()
                .header("Content/type", "application/json")
                .body(userReg.toString())
                .when().post();

        response.then()
                .statusCode(200);


    }
}
