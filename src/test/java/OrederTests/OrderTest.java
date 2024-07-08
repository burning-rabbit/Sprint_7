package OrederTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.Const;
import org.example.Order.OrderLogic;
import org.example.models.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.example.utils.Utils.randomString;

@RunWith(Parameterized.class)
public class OrderTest {

    private static List<String> color;
    public OrderTest(List<String> color) {
        this.color = color;
    }
    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {List.of("GREY")},
                {List.of("BLACK")},
                {List.of("GREY", "BLACK")},
        };
    }

    @Before
    public void setUp() { RestAssured.baseURI = Const.getUrl(); }

    @Test
    public void createOrder() {
               Order order = new Order()
                       .withFirstName(randomString(10))
                       .withLastName(randomString(10))
                       .withAddress(randomString(10))
                       .withMetroStation("4")
                       .withPhone("+7 800 355 35 35")
                       .withRentTime(3)
                       .withDeliveryDate("2020-06-06")
                       .withComment(randomString(10))
                       .withColor(color);

        OrderLogic orderLogic = new OrderLogic();
        Response response = orderLogic.create(order);
        Assert.assertEquals(201, response.statusCode());
        }


}
