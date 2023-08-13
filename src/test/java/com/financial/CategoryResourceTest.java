package com.financial;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CategoryResourceTest {

    @Test
    public void testCreateCategoryEndpoint() {
        given().contentType("application/json")
                .body("{\"name\": \"Category 1\"}")
                .when()
                .post("/categories")
                .then()
                .statusCode(201)
                .body("name", is("Category 1"));
    }

}
