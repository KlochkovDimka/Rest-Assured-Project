package org.example.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SpecificationResponse {

    public ResponseSpecification getSpecResponse(String schemaJson) {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody(matchesJsonSchemaInClasspath(schemaJson))
                .build();
    }


}
