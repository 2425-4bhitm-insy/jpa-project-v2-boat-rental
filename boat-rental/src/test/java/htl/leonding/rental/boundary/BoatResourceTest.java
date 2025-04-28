package htl.leonding.rental.boundary;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class BoatResourceTest {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.port = 8080;
        RestAssured.basePath = "/boat";
    }

    @Test
    void testGetAllBoats() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/boat/allBoats")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].class", equalTo("htl.leonding.rental.entity.Boat"));
    }

    @Test
    void testGetSingleBoat() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/boat/singleBoat/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Sea Breeze"))
                .body("description", equalTo("Small sailboat, perfect for beginners."));
    }

    @Test
    void testGetSingleBoatNotFound() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/boat/singleBoat/9999")
                .then()
                .statusCode(404);
    }

    @Test
    void testGetAllYachts() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/boat/allYachts")
                .then()
                .statusCode(200);
    }
}
