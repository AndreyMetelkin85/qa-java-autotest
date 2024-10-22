package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseApiMethods {

    public Response get(String endpoint, String token) {
        return RestAssured
                .given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response post(String endpoint, String body, String token) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response delete(String endpoint, String token) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}
