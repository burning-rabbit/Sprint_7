package LoginCourierTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.CONST;
import org.example.courier.CourierClient;
import org.example.models.Courier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.courier.CourierGenerator.randomCourier;
import static org.example.models.CourierCreds.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class CourierLoginRequiredTest {
    private CourierClient courierClient;
    private Integer id;

    @Before
    public void setUp() { RestAssured.baseURI = CONST.getUrl(); }

    @Test
    public void loginCourier() {
        Courier courier = randomCourier();
        courierClient = new CourierClient();
        courierClient.create(courier);

        Response loginResponse = courierClient.login(credsFromCourier(courier));
        id = loginResponse.path("id");
        assertEquals(200, loginResponse.statusCode());

        Response loginResponse1 = courierClient.login(credsWithoutLogin(courier));
        assertEquals(400, loginResponse1.statusCode());
        loginResponse1.then().body("message", equalTo("Недостаточно данных для входа"));

    }

    @After
    public void tearDown() {
        Response deleteResponse = courierClient.delete(id);
        assertEquals(200, deleteResponse.statusCode());
    }
}
