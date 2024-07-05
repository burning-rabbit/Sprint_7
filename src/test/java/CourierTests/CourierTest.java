package CourierTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.CONST;
import org.example.models.Courier;
import org.example.courier.CourierClient;
import org.example.models.CourierCreds;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.courier.CourierGenerator.randomCourier;

public class CourierTest {
    private CourierClient courierClient;
    private Integer id;

    @Before
    public void setUp() { RestAssured.baseURI = CONST.getUrl(); }

    @Test
    public void createCourier() {
        Courier courier = randomCourier();

        courierClient = new CourierClient();

        Response response = courierClient.create(courier);

        Assert.assertEquals(201, response.statusCode());

        Response loginResponse = courierClient.login(CourierCreds.credsFromCourier(courier));
        id = loginResponse.path("id");

        Assert.assertEquals(200, loginResponse.statusCode());

    }
    @After
    public void tearDown() {
        Response deleteResponse = courierClient.delete(id);
        Assert.assertEquals(200, deleteResponse.statusCode());
    }
}
