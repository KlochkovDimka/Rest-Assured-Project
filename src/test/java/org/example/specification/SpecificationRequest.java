package org.example.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.example.dto.users.UserAuthentication;

public class SpecificationRequest<T> {
    private final String URI = "https://aqa-api.javacode.ru/api";

    public RequestSpecification getRequestNoAuthentication(UserAuthentication user) {
        return new RequestSpecBuilder()
                .setBaseUri(URI)
                .addHeader("Content-Type", "application/json")
                .setBody(user)
                .build();
    }

    public RequestSpecification getRequest(String token, T t) {
        return new RequestSpecBuilder()
                .setBaseUri(URI)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", token)
                .setBody(t)
                .build();
    }
}
