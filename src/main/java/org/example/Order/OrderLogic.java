package org.example.Order;

import io.restassured.response.Response;
import org.example.models.Order;

import static io.restassured.RestAssured.given;

public class OrderLogic {
    private static final String CREATE_ENDPOINT = "/api/v1/orders";

    public Response create(Order order) {
        return given()
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post(CREATE_ENDPOINT);
    }
}
