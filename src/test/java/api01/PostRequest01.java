package api01;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

public class PostRequest01 extends TestBase{

    @Test
    public void post01() {
        String jsonReqBody = "{\n" +
                "\"firstname\": \"Adil\",\n" +
                "\"lastname\": \"Yesilmen\",\n" +
                "\"totalprice\": 5000,\n" +
                "\"depositpaid\": true,\n" +
                "\"bookingdates\": {\n" +
                "\"checkin\": \"2021-05-02\",\n" +
                "\"checkout\": \"2021-07-09\"\n" +
                "},\n" +
                "\"additionalneeds\": \"Wifi\"\n" +
                "\n" +
                "}";
        Response response= given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().
                basic("admin","password123")
                .body(jsonReqBody).
                        when().
                        post("/booking");

        response.prettyPrint();

        //status code 200
        response.
                then().
                assertThat().
                statusCode(200);
        JsonPath json =response.jsonPath();
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"),"Adil");
        softAssert.assertEquals(json.getString("booking.lastname"),"Yesilmen");
        softAssert.assertEquals(json.getString("booking.totalprice"),5000);
        softAssert.assertEquals(json.getString("booking.depositpaid"),true);
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"),"2021-05-02");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"),"2021-07-09");
        softAssert.assertEquals(json.getString("booking.additionalneeds"),"Wifi");


    softAssert.assertAll();
    }
}