package CourierTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.Const;
import org.example.courier.CourierClient;
import org.example.models.Courier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.courier.CourierGenerator.*;

public class TestCreatingCourierWithOutPassword {

    @Before
    public void setUp() { RestAssured.baseURI = Const.getUrl(); }

    @Test
    public void createCourierWithOutLogin() {
        Courier courier = withOutPasswordCourier();
        CourierClient courierClient = new CourierClient();
        Response response1 = courierClient.create(courier);

        Assert.assertEquals(400, response1.statusCode());
    }
}
