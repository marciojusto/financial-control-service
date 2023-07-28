package com.financial;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BankResourceTest {

    @Test
    public void testCreateBankEndpoint() {
        given().contentType("application/json")
                .body("{\"name\": \"Bank 1\"}")
                .when()
                .post("/banks")
                .then()
                .statusCode(201)
                .body("name", is("Bank 1"));
    }

}
