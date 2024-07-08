package org.example.courier;

import io.restassured.response.Response;
import org.example.models.Courier;
import org.example.models.CourierCreds;

import static io.restassured.RestAssured.given;

public class CourierClient {
    private static final String CREATE_ENDPOINT = "/api/v1/courier";
    private static final String LOGIN_ENDPOINT = "/api/v1/courier/login";
    private static final String DELETE_ENDPOINT = "api/v1/courier/{id}";

    public Response create(Courier courier) {
        return  given().log().all()
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(CREATE_ENDPOINT);
    }
    public Response login(CourierCreds creds) {
        return given().log().all()
                .header("Content-type", "application/json")
                .body(creds)
                .when()
                .post(LOGIN_ENDPOINT);
    }

    public Response delete(Integer id) {
        return  given().log().all()
                .pathParam("id", id)
                .when()
                .delete(DELETE_ENDPOINT);
    }
}
