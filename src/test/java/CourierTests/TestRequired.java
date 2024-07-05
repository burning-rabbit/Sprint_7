package CourierTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.CONST;
import org.example.courier.CourierClient;
import org.example.models.Courier;
import org.example.models.CourierCreds;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.courier.CourierGenerator.*;

public class TestRequired {
    private CourierClient courierClient;
    private Integer id;

    @Before
    public void setUp() { RestAssured.baseURI = CONST.getUrl(); }

    @Test
    public void createCourier() {
        Courier courier = withOutLoginCourier();
        courierClient = new CourierClient();
        Response response = courierClient.create(courier);

        Assert.assertEquals(400, response.statusCode());

        Courier courier1 = withOutPasswordCourier();
        courierClient = new CourierClient();
        Response response1 = courierClient.create(courier1);

        Assert.assertEquals(400, response1.statusCode());

        Courier courier2 = withOutFirstNameCourier();
        courierClient = new CourierClient();
        Response response2 = courierClient.create(courier2);

        Assert.assertEquals(201, response2.statusCode());

        Response loginResponse = courierClient.login(CourierCreds.credsFromCourier(courier2));
        id = loginResponse.path("id");

    }

    @After
    public void tearDown() {
        Response deleteResponse = courierClient.delete(id);
        Assert.assertEquals(200, deleteResponse.statusCode());
    }
}
