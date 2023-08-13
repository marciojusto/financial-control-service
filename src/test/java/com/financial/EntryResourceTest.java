package com.financial;

import com.financial.entities.Bank;
import com.financial.entities.Category;
import com.financial.entities.Entry;
import com.financial.entities.SubCategory;
import com.financial.enums.TypeEnum;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.Date;
import java.util.UUID;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class EntryResourceTest {

    private static final Bank bank = new Bank();
    private static final Category category = new Category();
    private static final SubCategory subCategory = new SubCategory();

    @Test
    @Order(1)
    public void testCreateBankEndpoint() {
        bank.id = UUID.fromString(given().contentType("application/json")
                                         .body("{\"name\": \"One Bank\"}")
                                         .when()
                                         .post("/banks")
                                         .then()
                                         .statusCode(201)
                                         .extract()
                                         .path("id"));
    }

    @Test
    @Order(2)
    public void testCreateCategoryEndpoint() {
        category.id = UUID.fromString(given().contentType("application/json")
                                             .body("{\"name\": \"Gasto Essencial\"}")
                                             .when()
                                             .post("/categories")
                                             .then()
                                             .statusCode(201)
                                             .extract()
                                             .path("id"));
    }

    @Test
    @Order(3)
    public void testCreateSubcategoryEndpoint() {
        subCategory.name = "Transporte";
        subCategory.category = category;

        subCategory.id = UUID.fromString(given().contentType("application/json")
                                                .body(subCategory)
                                                .when()
                                                .post("/sub-categories")
                                                .then()
                                                .statusCode(201)
                                                .extract()
                                                .path("id"));
    }

    @Test
    @Order(4)
    public void testCreateEntryEndpoint() {
        Entry entry = new Entry();
        entry.description = "DD PT67100866 SANT CONSUMER P 00124141835";
        entry.entryDate = Date.valueOf("2023-05-05");
        entry.value = 198.68;
        entry.type = TypeEnum.DEBIT;
        entry.bank = bank;
        entry.category = category;
        entry.subCategory = subCategory;

        given().contentType("application/json")
               .body(entry)
               .when()
               .post("/entries")
               .then()
               .statusCode(201);
    }

}
