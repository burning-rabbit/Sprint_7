package CourierTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.Const;
import org.example.courier.CourierClient;
import org.example.models.Courier;
import org.example.models.CourierCreds;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.courier.CourierGenerator.*;

public class TestCreatingCourierWithOutFirstName {
    private CourierClient courierClient;
    private Integer id;

    @Before
    public void setUp() { RestAssured.baseURI = Const.getUrl(); }

    @Test
    public void createCourierWithOutLogin() {

        Courier courier = withOutFirstNameCourier();
        courierClient = new CourierClient();
        Response response2 = courierClient.create(courier);

        Assert.assertEquals(201, response2.statusCode());

        Response loginResponse = courierClient.login(CourierCreds.credsFromCourier(courier));
        id = loginResponse.path("id");

    }

    @After
    public void tearDown() {
        Response deleteResponse = courierClient.delete(id);
        Assert.assertEquals(200, deleteResponse.statusCode());
    }
}
