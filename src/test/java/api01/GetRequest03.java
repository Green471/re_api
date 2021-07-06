package api01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest03 {
    /*
	 Positive Scenario:
	 When I send a GET request to REST API URL
	 https://restful-booker.herokuapp.com/booking/1
   	And Accept type is “application/JSON”
   	Then
   	HTTP Status Code should be 200
   	And Response format should be “application/JSON”
   	And first name should be “Eric”
   	And lastname should be “Brown”
   	And checkin date should be “2018-11-04”
   	And checkout date should be “2021-01-31"

   */

    @Test
    public void get01(){
        Response response = given().accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking/1");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/JSON").
                body("firstname", Matchers.equalTo("Mark"),
                        "lastname",Matchers.equalTo("Wilson"),
                       "bookingdates.checkin",Matchers.equalTo("2021-03-26"),
                        "bookingdates.checkout",Matchers.equalTo("2021-04-18"),
                        "totalprice",Matchers.equalTo(969));



        Assert.assertEquals(200,response.getStatusCode());

    }

}
