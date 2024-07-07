package CourierTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.CONST;
import org.example.courier.CourierClient;
import org.example.models.Courier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.courier.CourierGenerator.*;

public class TestCreatingCourierWithOutLogin {

    @Before
    public void setUp() { RestAssured.baseURI = CONST.getUrl(); }

    @Test
    public void createCourierWithOutLogin() {
        Courier courier = withOutLoginCourier();
        CourierClient courierClient = new CourierClient();
        Response response = courierClient.create(courier);

        Assert.assertEquals(400, response.statusCode());

    }
}