package api01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class GetRequest08 extends TestBase {
    /*
     * When I send a GET request to REST API URL
     * https://restful-booker.herokuapp.com/booking/5 Then HTTP Status Code should
     * be 200 And response content type is “application/JSON” And response body
     * should be like; {“firstname”: “Sally”, “lastname”: “Ericsson”, “totalprice”:
     * 111, “depositpaid”: false, “bookingdates”: {“checkin”: “2017-05-23",
     * “checkout”:“2019-07-02" }
     */

    @Test
    public void get01(){
        spec01.pathParam("depositpaid",5);
        Response response = given().
                spec(spec01).
                when().
                get("/booking/{depositpaid}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();    //JSON formatindaki data'larin icinde gezmemizi kolaylastirir.
                                                    //It makes it easy for us to navigate through data in JSON format.
                                                    //by using jSonPath class i can use methodes json class..
        System.out.println(jsonPath.getString("firstname"));
        assertEquals("Firstname is not as expected","Mark",jsonPath.getString("firstname"));
        assertEquals("last name is not as expected","Brown",jsonPath.getString("lastname"));
        assertEquals("totalPrice is not as expected",586,jsonPath.getInt("totalprice"));
        System.out.println(jsonPath.getBoolean("depositpaid"));
        System.out.println(jsonPath.getString("bookingdates"));
        System.out.println(jsonPath.getString("bookingdates.checkin"));

    }


}
