package com.myapp.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ProductResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/products")
          .then()
             .statusCode(204)
             ;
    }

}