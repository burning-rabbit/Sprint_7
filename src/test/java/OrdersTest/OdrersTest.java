package OrdersTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.CONST;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OdrersTest {
    private String GET_ENDPOINT = "/api/v1/orders";

    @Before
    public void setUp() { RestAssured.baseURI = CONST.getUrl(); }

    @Test
    public void getOrders() {
            Response response = given()
                .header("Content-type", "application/json")
                .when()
                .get(GET_ENDPOINT);
            response.then().body("orders", notNullValue());

    }
}
